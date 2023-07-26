import java.sql.*;

public class JdbcDaoDemo {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
//        Student s1 = dao.getStudent(13);
//        System.out.println(s1.sname);
        Student s2 = new Student();
        s2.rollno = 15;
        s2.sname = "Archana";
        dao.connect();
        dao.addStudent(s2);

        dao.addStudent(s2);
    }
}
class StudentDAO{
    Connection con = null;
    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost/navin","postgres","milan123");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public Student getStudent(int rollno)  {

        try {
            String query = "select sname from student where rollno=" + rollno;
            Student s = new Student();
            s.rollno = rollno;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String name = rs.getString(1);
            s.sname = name;
            return s;
        } catch (Exception e) {
            System.out.println(e);;
        }
        return null;

    }

    public void addStudent(Student s)
    {
        String query = "insert into student values(?,?)";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1,s.rollno);
            pst.setString(2,s.sname);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);;
        }
    }
}
class Student {
    int rollno;
    String sname;
}
