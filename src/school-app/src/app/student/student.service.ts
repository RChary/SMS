import { Student } from "./Student";
import { Injectable } from '@angular/core';
import { Observable, Subject, throwError} from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Http, HttpModule} from '@angular/http';
import { HttpClientModule} from '@angular/common/http';



@Injectable()
export class StudentService {

    private getStudents = 'http://localhost:8080/student/allStudents';

    private findByIdUrl = 'http://localhost:8080/student/getStudent?id=';

    private deleteStudentById = 'http://localhost:8080/student/deleteStudent?id=';

    private static readonly saveStudent = 'http://localhost:8080/student/save';

    private headers = new HttpHeaders({ 'Content-Type': 'application/json' });


    constructor(private http: HttpClient) {
        console.log('Student service connected...');
    }


    findAll(): Observable<Student[]> {
        alert(28);
        return this.http.get<Student[]>(this.getStudents);
    }


    findById(id: number): Observable<Student> {

        return this.http.get<Student>(this.findByIdUrl + id);
    }

    createStudent(student: Student): Observable<Student> {
        alert(StudentService.saveStudent);
        alert(student.firstName);
        console.log(student.firstName);
        return this.http.post<Student>(StudentService.saveStudent, student, { headers: this.headers });
    }


    deleteByStudentId(id: number): Observable<Object> {
        return this.http.delete(this.deleteStudentById + id);
    }




}
