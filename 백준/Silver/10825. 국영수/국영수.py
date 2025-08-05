import sys
from functools import cmp_to_key
class Student:
    def __init__(self,name,kor,eng,math):
        self.name = name
        self.kor = kor
        self.eng = eng
        self.math = math

def compare_students(p1, p2):
    if p1.kor != p2.kor:
        return p2.kor - p1.kor

    if p1.eng != p2.eng:
        return p1.eng - p2.eng

    if p1.math != p2.math:
        return p2.math - p1.math
    
    if p1.name < p2.name:
        return -1  # 이름 사전 순 증가
    elif p1.name > p2.name:
        return 1
    else:
        return 0

n = int(sys.stdin.readline())
students =[]
for i in range(n):
    line = sys.stdin.readline().split()
    name = line[0]
    kor = int(line[1])
    eng = int(line[2])
    math = int(line[3])
    students.append(Student(name,kor,eng,math))

sorted_students = sorted(students, key=cmp_to_key(compare_students))


for student in sorted_students:
    print(student.name)