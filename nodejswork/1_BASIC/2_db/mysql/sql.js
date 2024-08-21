// 2db/sql.js

module.exports={
    //검색
    employeeList :`select * from emp`

    //입력 -> insert into emp set empno=9912, ename='홍씨', job="아이티"
    , employeeeInsert:'insert into emp set ?'
    

    //수정
    // 실제 수정 쿼리 -> update emp set ename="김씨",job="개발" where empno=9912
    , employeeUpdate : "update emp set ? where empno=?"
    // where 도 ?로 가능하지만 사원 번호 하나만 받을 경우에
    //이렇게 작성을 해도 된다.

    //부서 정보 수정
    ,deptUpdate:"update emp set ? where deptno=?"

    //삭제
    , employeeDelete : "delete from emp where empno=?"


    // 부서 번호 조회
    
    ,deptList:"select e.EMPNO ,e.ENAME ,e.DEPTNO ,d.DNAME ,d.LOC from emp e inner join dept d on e.deptno = d.deptno"
    
    
    //새로운 부서 입력
    ,deptInsert:"insert into dept set ?"
}
