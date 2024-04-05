CREATE TABLE IF NOT EXISTS student
(

    studentId SERIAL PRIMARY KEY,
    name      VARCHAR        NOT NULL,
    email     VARCHAR UNIQUE NOT NULL

);

CREATE TABLE IF NOT EXISTS course
(

    courseId SERIAL PRIMARY KEY,
    name     VARCHAR NOT NULL

);

CREATE TABLE IF NOT EXISTS studentCourses
(
    student_id INT,
    course_id  INT,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES student (studentId),
    FOREIGN KEY (course_id) REFERENCES course (courseId)
);
