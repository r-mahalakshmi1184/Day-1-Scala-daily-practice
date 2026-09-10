// ==========================================
// Day 1 - Scala Essentials
// Student Grade Processor
// ==========================================

case class Student(
  id: Int,
  name: String,
  marks: Map[String, Int]
)

case class StudentResult(
  id: Int,
  name: String,
  total: Int,
  average: Double,
  grade: String,
  passed: Boolean
)

// ==========================================
// Logger Trait
// ==========================================

trait Logger {
  def log(message: String): Unit
}

class ConsoleLogger extends Logger {

  override def log(message: String): Unit = {
    println(s"[LOG] $message")
  }

}

class DetailedLogger extends Logger {

  override def log(message: String): Unit = {
    println(s"[DETAILED LOG] Processing: $message")
  }

}

// ==========================================
// Main Object
// ==========================================

object StudentGradeProcessor {

  // Calculate total marks
  def calculateTotal(marks: Map[String, Int]): Int = {
    marks.values.sum
  }

  // Calculate average marks
  def calculateAverage(marks: Map[String, Int]): Double = {
    marks.values.sum.toDouble / marks.size
  }

  // Calculate grade
  def calculateGrade(average: Double): String = {

    if (average >= 90) {
      "A"
    } else if (average >= 80) {
      "B"
    } else if (average >= 70) {
      "C"
    } else if (average >= 60) {
      "D"
    } else if (average >= 40) {
      "E"
    } else {
      "F"
    }
  }

  // Check whether student passed
  def isPassed(
    marks: Map[String, Int],
    passingMark: Int
  ): Boolean = {

    marks.values.forall(_ >= passingMark)
  }

  // ==========================================
  // Main Method
  // ==========================================

  def main(args: Array[String]): Unit = {

    println("==========================================")
    println("       STUDENT GRADE PROCESSOR")
    println("==========================================")

    // ==========================================
    // val
    // ==========================================

    val passingMark = 40

    println(s"\nPassing Mark: $passingMark")

    // ==========================================
    // var
    // ==========================================

    var processedStudents = 0

    println(
      s"Initial Students Processed: $processedStudents"
    )

    // ==========================================
    // lazy val
    // ==========================================

    lazy val projectName = {

      println("Initializing project name...")

      "Student Grade Processor"
    }

    println("\nBefore accessing lazy val")

    println(
      s"Project Name: $projectName"
    )

    println(
      s"Project Name Again: $projectName"
    )

    // ==========================================
    // Immutable Collection - List
    // ==========================================

    val subjectsList =
      List(
        "Scala",
        "Spark",
        "SQL"
      )

    println("\n--- List ---")
    println(subjectsList)

    // ==========================================
    // Immutable Collection - Vector
    // ==========================================

    val marksVector =
      Vector(
        85,
        78,
        90,
        92,
        88
      )

    println("\n--- Vector ---")
    println(marksVector)

    // ==========================================
    // Immutable Collection - Set
    // ==========================================

    val subjectsSet =
      Set(
        "Scala",
        "Spark",
        "SQL",
        "Scala"
      )

    println("\n--- Set ---")
    println(subjectsSet)

    // ==========================================
    // Immutable Collection - Map
    // ==========================================

    val subjectMarks =
      Map(
        "Scala" -> 85,
        "Spark" -> 78,
        "SQL" -> 90
      )

    println("\n--- Map ---")
    println(subjectMarks)

    // ==========================================
    // Student Data
    // ==========================================

    val students =
      List(

        Student(
          101,
          "Arun",
          Map(
            "Scala" -> 85,
            "Spark" -> 78,
            "SQL" -> 90
          )
        ),

        Student(
          102,
          "Priya",
          Map(
            "Scala" -> 92,
            "Spark" -> 88,
            "SQL" -> 95
          )
        ),

        Student(
          103,
          "Karthik",
          Map(
            "Scala" -> 35,
            "Spark" -> 45,
            "SQL" -> 50
          )
        )
      )

    // ==========================================
    // Display Students
    // ==========================================

    println("\n--- Students ---")

    students.foreach { student =>
      println(
        s"${student.id} - ${student.name}"
      )
    }

    // ==========================================
    // map() - Student Names
    // ==========================================

    val studentNames =
      students.map(_.name)

    println("\n--- Student Names ---")
    println(studentNames)

    // ==========================================
    // map() - Student IDs
    // ==========================================

    val studentIds =
      students.map(_.id)

    println("\n--- Student IDs ---")
    println(studentIds)

    // ==========================================
    // map() - Total Marks
    // ==========================================

    val totalMarks =
      students.map { student =>
        calculateTotal(student.marks)
      }

    println("\n--- Total Marks ---")
    println(totalMarks)

    // ==========================================
    // map() - Average Marks
    // ==========================================

    val averageMarks =
      students.map { student =>
        calculateAverage(student.marks)
      }

    println("\n--- Average Marks ---")

    averageMarks.foreach { average =>
      println(
        f"$average%.2f"
      )
    }

    // ==========================================
    // Grades
    // ==========================================

    println("\n--- Grades ---")

    averageMarks.foreach { average =>

      println(
        f"Average: $average%.2f | Grade: ${calculateGrade(average)}"
      )
    }

    // ==========================================
    // For-Comprehension + yield
    // ==========================================

    val results =
      for {

        student <- students

        total =
          calculateTotal(student.marks)

        average =
          calculateAverage(student.marks)

        grade =
          calculateGrade(average)

        passed =
          isPassed(
            student.marks,
            passingMark
          )

      } yield {

        processedStudents += 1

        StudentResult(
          student.id,
          student.name,
          total,
          average,
          grade,
          passed
        )
      }

    // ==========================================
    // Student Results
    // ==========================================

    println("\n==========================================")
    println("           STUDENT RESULTS")
    println("==========================================")

    results.foreach { result =>

      println(
        f"${result.id} | " +
        s"${result.name} | " +
        s"Total: ${result.total} | " +
        f"Average: ${result.average}%.2f | " +
        s"Grade: ${result.grade} | " +
        s"Passed: ${result.passed}"
      )
    }

    // ==========================================
    // Filter - Passed Students
    // ==========================================

    val passedStudents =
      results.filter(_.passed)

    println("\n--- Passed Students ---")

    passedStudents.foreach { student =>

      println(
        s"${student.name} - Grade ${student.grade}"
      )
    }

    // ==========================================
    // Filter - Failed Students
    // ==========================================

    val failedStudents =
      results.filter(!_.passed)

    println("\n--- Failed Students ---")

    failedStudents.foreach { student =>

      println(
        s"${student.name} - Grade ${student.grade}"
      )
    }

    // ==========================================
    // Topper
    // ==========================================

    val topper =
      results.maxBy(_.average)

    println("\n--- Topper ---")

    println(
      f"${topper.name} - Average: ${topper.average}%.2f"
    )

    // ==========================================
    // Class Average
    // ==========================================

    val classAverage =
      results.map(_.average).sum / results.size

    println("\n--- Class Average ---")

    println(
      f"$classAverage%.2f"
    )

    // ==========================================
    // For-Comprehension + yield
    // Student Subject Marks
    // ==========================================

    val studentMarks =
      for {

        student <- students

        (subject, mark) <- student.marks

      } yield {

        s"${student.name} scored $mark in $subject"
      }

    println("\n--- Student Subject Marks ---")

    studentMarks.foreach(println)

    // ==========================================
    // Collection Comparison
    // ==========================================

    val myList =
      List(
        "Scala",
        "Spark",
        "SQL"
      )

    val myVector =
      Vector(
        "Scala",
        "Spark",
        "SQL"
      )

    val mySet =
      Set(
        "Scala",
        "Spark",
        "SQL",
        "Scala"
      )

    val myMap =
      Map(
        "Scala" -> 85,
        "Spark" -> 78,
        "SQL" -> 90
      )

    println("\n--- Collection Comparison ---")

    println(
      s"List: $myList"
    )

    println(
      s"Vector: $myVector"
    )

    println(
      s"Set: $mySet"
    )

    println(
      s"Map: $myMap"
    )

    // ==========================================
    // Logger Trait
    // ==========================================

    val consoleLogger =
      new ConsoleLogger

    val detailedLogger =
      new DetailedLogger

    println("\n--- Logger Output ---")

    consoleLogger.log(
      "Student processing started"
    )

    detailedLogger.log(
      "Calculating grades for students"
    )

    consoleLogger.log(
      "Student processing completed"
    )

    // ==========================================
    // Processing Summary
    // ==========================================

    println("\n--- Processing Summary ---")

    println(
      s"Total Students Processed: $processedStudents"
    )

    println(
      s"Total Passed: ${passedStudents.size}"
    )

    println(
      s"Total Failed: ${failedStudents.size}"
    )

    // ==========================================
    // End
    // ==========================================

    println("\n==========================================")
    println("       PROCESSING COMPLETED")
    println("==========================================")
  }
}
