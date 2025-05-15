package com.younggalee.ioc.section01.xmlconfig;

public class StudentService {
    public void getStudentAll(){
        System.out.println("학생 전체 조회용 비즈니스 로직 실행");
    }

    public void registStudent(Student stu){
        System.out.println("학생 등록용 비즈니스 로직 실행");
    }
}
