package TestWork;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class TestService {

    public TestService() {}

    public void tryMethod(ProcessRule pr1, AttestRule at1) {
        List<Rule> allRules = new ArrayList<>();

        allRules.add(pr1);
        allRules.add(at1);

        for (Rule r: allRules) {
            if (r instanceof GeneosProcessRule) {
                ProcessRule pr = (ProcessRule) r;
                System.out.println("this is a process rul");
                System.out.println(pr.hosts.size());
                r.compliantLevel = pr.hosts.isEmpty() ? CompliantLevel.NO : CompliantLevel.YES;
                continue;
            }
            if (r instanceof GeneosAttestRule) {
                AttestRule ar = (AttestRule) r;
                System.out.println("this is a attest rul");
                System.out.println(ar.approvedBy);
                r.compliantLevel = ar == null ? CompliantLevel.NO : CompliantLevel.YES;

            }
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        TestService ts = new TestService();

        ProcessRule pr = new ProcessRule();
        pr.hosts =  asList("hey");

        AttestRule ar = new AttestRule();
        ar.approvedBy = "e841772";

        ts.tryMethod(pr, ar);
    }

}
