import { Component, OnInit } from '@angular/core';
import { StudentService} from '../student.service';
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Student } from '../Student';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs/operators';



@Component({
    selector: 'app-student-create',
    templateUrl: './student-create.component.html',
    styleUrls: ['./student-create.component.css'],
    providers: [StudentService]

})
export class StudentCreateComponent implements OnInit {


    isValidFormSubmitted = null;
    id: number;
    studentForm:FormGroup;
    submitted = false;

    private sub: any;



    constructor(private route: ActivatedRoute,
        private router: Router,
        private studentService: StudentService) { }


   
    ngOnInit() {   
       this.studentForm = new FormGroup({
        rollNo: new FormControl('', [Validators.required, Validators.minLength(3),Validators.maxLength(4)]),
        firstName: new FormControl('', [Validators.required, Validators.minLength(3),Validators.maxLength(25)]),
        fName: new FormControl('', [Validators.required,Validators.maxLength(3),Validators.minLength(20)]),
        age: new FormControl('', [Validators.required,Validators.min(3),Validators.max(20)])
    });

        
        this.sub = this.route.params.subscribe(params => {
            this.id = params['id'];
        });
 
        if (this.id) {
            alert(this.id);
            this.studentService.findById(this.id).subscribe(
                studenttemp => {
                    this.id = studenttemp.id;
                    this.studentForm.patchValue({
                        firstName: studenttemp.firstName,
                        rollNo: studenttemp.rollNo,
                        age: studenttemp.age,
                    });
                }, error => {
                    console.log(error);
                }
            );

        }


    }


    onSubmit() {
        
        this.isValidFormSubmitted = false;
        if (this.studentForm.invalid) {
        return;
        }
        this.isValidFormSubmitted = true;
   
        if (this.id) {
            alert(this.studentForm.controls['rollNo'].value);
            let student: Student = new Student(this.id,
                this.studentForm.controls['rollNo'].value,
                this.studentForm.controls['firstName'].value,this.studentForm.controls['fName'].value,
                this.studentForm.controls['age'].value);
            this.studentService.createStudent(student).subscribe(
                res => {
                    this.router.navigate(['/students']);
                }
            );
        } else {

            let student: Student = new Student(null,
                this.studentForm.controls['rollNo'].value,
                this.studentForm.controls['firstName'].value,this.studentForm.controls['fName'].value,
                this.studentForm.controls['age'].value);
            this.studentService.createStudent(student).subscribe(
                res => {
                    this.router.navigate(['/students']);
                });
        }

    }


    ngOnDestroy(): void {
        this.sub.unsubscribe();
    }

    redirectStudentPage() {
        this.router.navigate(['/students']);
    }


    get rollNo() {
        return this.studentForm.get('rollNo');
    }
    
    get firstName(){
        return this.studentForm.get('firstName');
        }
    get age(){
        return this.studentForm.get('age');
        }

}
