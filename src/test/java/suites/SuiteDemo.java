package suites;

import cases.exer01.CadastrarBurgerEats;
import cases.exer02.CabastrarCliente;
import cases.exer04.Ultimateqa;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import pages.BugBankCadastro;

@Suite
@SelectClasses({CadastrarBurgerEats.class, Ultimateqa.class})
public class SuiteDemo {
}
