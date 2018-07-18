import{Component, OnInit}from '@angular/core';
import {StudentService}from '../student.service';
import {FormControl, FormGroup, Validators}from "@angular/forms";
import {Student}from '../Student';
import {ActivatedRoute, Router}from '@angular/router';
import {first}from 'rxjs/operators';



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
    mobnumPattern = "^((\\+91-?)|0)?[0-9]{10}$";



    private sub: any;



    constructor(private route: ActivatedRoute,
        private router: Router,
        private studentService: StudentService) { }



    ngOnInit() {


       this.studentForm = new FormGroup({
        rollNo: new FormControl('', [Validators.required, Validators.minLength(3),Validators.maxLength(4)]),
        firstName: new FormControl('', [Validators.required, Validators.minLength(3),Validators.maxLength(25)]),
        lastName: new FormControl('', [Validators.required,Validators.maxLength(30),Validators.minLength(3)]),
        age: new FormControl('', [Validators.required,Validators.min(3),Validators.max(20)]),
fatherName: new FormControl('', [Validators.required,Validators.maxLength(30),Validators.minLength(3)]),
motherName: new FormControl('', [Validators.required,Validators.maxLength(30),Validators.minLength(3)]),
 standard: new FormControl('', [Validators.required,Validators.min(1),Validators.max(12)]),
primaryContactNo : new FormControl('', [Validators.required,Validators.pattern(this.mobnumPattern)]),
 secondaryContactNo: new FormControl('', [Validators.required,Validators.pattern(this.mobnumPattern)]),
emergencyContactNo: new FormControl('', [Validators.required,Validators.pattern(this.mobnumPattern)]),
email: new FormControl('', [Validators.required,Validators.maxLength(30),Validators.minLength(3)])

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
                        rollNo: studenttemp.rollNo,

                        firstName: studenttemp.firstName,
lastName: studenttemp.lastName,
 age: studenttemp.age,
fatherName: studenttemp.fatherName,
motherName: studenttemp.motherName,
standard: studenttemp.standard,
primaryContactNo: studenttemp.primaryContactNo,
secondaryContactNo: studenttemp.secondaryContactNo,
emergencyContactNo: studenttemp.emergencyContactNo,
email: studenttemp.email,
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
            alert('sample');
            let student: Student = new Student(this.id,
                this.studentForm.controls['rollNo'].value,
                this.studentForm.controls['firstName'].value,
                this.studentForm.controls['lastName'].value,
                this.studentForm.controls['age'].value,
               this.studentForm.controls['fatherName'].value,
               this.studentForm.controls['motherName'].value,
               this.studentForm.controls['standard'].value,
               this.studentForm.controls['primaryContactNo'].value,
               this.studentForm.controls['secondaryContactNo'].value,
               this.studentForm.controls['emergencyContactNo'].value,
               this.studentForm.controls['email'].value);
            this.studentService.createStudent(student).subscribe(
                res => {
                    this.router.navigate(['/students']);
                }
            );
        } else {

            alert(this.studentForm.controls['rollNo'].value);
            let student: Student = new Student(this.id,
                this.studentForm.controls['rollNo'].value,
                this.studentForm.controls['firstName'].value,
                this.studentForm.controls['lastName'].value,
                this.studentForm.controls['age'].value,
               this.studentForm.controls['fatherName'].value,
               this.studentForm.controls['motherName'].value,
               this.studentForm.controls['standard'].value,
               this.studentForm.controls['primaryContactNo'].value,
               this.studentForm.controls['secondaryContactNo'].value,
               this.studentForm.controls['emergencyContactNo'].value,
               this.studentForm.controls['email'].value);


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


     get lastName() {
        return this.studentForm.get('lastName');
       }

 get fatherName() {
        return this.studentForm.get('fatherName');
       }

 get motherName() {
        return this.studentForm.get('fatherName');
       }

 get standard() {
        return this.studentForm.get('standard');
       }

get primaryContactNo() {
        return this.studentForm.get('primaryContactNo');
       }

get secondaryContactNo() {
        return this.studentForm.get('secondaryContactNo');
       }


get emergencyContactNo() {
        return this.studentForm.get('emergencyContactNo');
       }
get email() {
        return this.studentForm.get('email');
       }

}
