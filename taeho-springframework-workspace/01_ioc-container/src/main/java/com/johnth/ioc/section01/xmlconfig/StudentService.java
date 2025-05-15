package com.johnth.ioc.section01.xmlconfig;

public class StudentService {
    public void getStudentAll(){
        System.out.println("학생 전체 조회 비즈니스 로직 실행");
    }
    public void registerStudent(Student student){
        System.out.println("학생 등록 로직 실행");
    }
}
