import com.jprogrammers.model.Car;
import com.jprogrammers.model.User;
import com.jprogrammers.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by jprogrammers.
 */
public class Test {

    public static void main(String[] args) {
        Car car = new Car();
        car.setCompany("porsche");
        car.setModel("911");
        car.setYear(2015);

        User user = new User();
        user.setFirstName("vahid");
        user.setLastName("forghani");

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        session.save(car);
        user.setCar(car);
        session.save(user);

        transaction.commit();
        session.flush();
        session.close();

    }

}
