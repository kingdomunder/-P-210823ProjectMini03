-- student insert
insert into student values(student_idx.NEXTVAL, '임우송', '경기도 화성', '부동산학과', null);
insert into student values(student_idx.NEXTVAL, '서주연', '경기도 성남', '경찰행정학과', null);
insert into student values(student_idx.NEXTVAL, '장혜민', '서울 강서구', '언론홍보학과', null);

-- study insert
insert into study values(study_idx.NEXTVAL, '자바 알고리즘', '자바로 알고리즘 뿌시기', 1, '화');
insert into study values(study_idx.NEXTVAL, '자바 리뷰', '자바 마스터를 향해', 2, '월');
insert into study values(study_idx.NEXTVAL, '파이썬 알고리즘', '파이썬으로 알고리즘 뿌시기', 3, '수');

-- attendance insert
insert into attendance values(1, 33, 0, 0);
insert into attendance values(2, 32, 3, 0);
insert into attendance values(3, 31, 1, 1);

commit;
