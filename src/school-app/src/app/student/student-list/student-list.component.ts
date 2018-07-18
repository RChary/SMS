import { Component, OnInit } from '@angular/core';
import { Student } from "../Student";
import { StudentService } from '../student.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
    selector: 'app-student-list',
    templateUrl: './student-list.component.html',
    styleUrls: ['./student-list.component.css'],
    providers: [StudentService]
})
export class StudentListComponent implements OnInit {

    constructor(private studentService: StudentService, private route: ActivatedRoute, private router: Router) { }
    private students: Student[];

    ngOnInit() {
        this.getAllUsers();
    }

    getAllUsers() {
        this.studentService.findAll().subscribe(
            students => {
                this.students = students;
            },
            err => {
                console.log(err);
            }

        );
    }

    redirectNewUserPage(){
        this.router.navigate(['students/create',[]]);
    }

    editStudentPage(student: Student) {
        if (student) {
            this.router.navigate(['/students/edit/', student.id]);
        }
    }

    deleteStudent(student: Student) {
alert(33);
        if (student) {
            this.studentService.deleteByStudentId(student.id).subscribe(
                res => {
                    this.getAllUsers();
                    this.router.navigate(['/students']);
                    console.log('done');
                }
            );
        }
    }

}
