package generics;
import net.mindview.util.New;
import typeinfo.pets.*;
import java.util.*;

public class LimitsOfInference {
    static void f(Map<Person, List<? extends Pet>> petPeople) {

    }

    public static void main(String[] args) {
        f(New.map());

    }
}
