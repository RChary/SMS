export class Student {
    id: number;
    rollNo : number;
    firstName: string;
    age: number;
    lastName:string;
fatherName:string;
motherName:string;
standard:string;
secondaryContactNo:string;
emergencyContactNo:string;
primaryContactNo:string;
email:string;


  constructor(id:number,rollNo: number,
               firstName: string,
               lastName:string,
               age: number,
               fatherName:string,
               motherName:string,
               standard:string,
               primaryContactNo:string,
               secondaryContactNo:string,
               emergencyContactNo:string,
               email:string){
    this.id=id;
    this.rollNo = rollNo;
    this.firstName = firstName;
    this.age = age;
    this.lastName=lastName;
    this.fatherName=fatherName;
        this.motherName=motherName;
        this.standard=standard;
        this.secondaryContactNo=secondaryContactNo;
        this.emergencyContactNo=emergencyContactNo;
       this.primaryContactNo=primaryContactNo;
       this.email=email;
  }

}
