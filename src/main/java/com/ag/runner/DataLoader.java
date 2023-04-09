package com.ag.runner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ag.db.CitizenPlan;
import com.ag.db.CitizenPlanRepository;
import com.ag.utils.PlanUtils;

@Component
public class DataLoader implements CommandLineRunner {

	String[] gender = { "Male", "Female" };

	@Autowired
	CitizenPlanRepository repoObj;

	@Override
	public void run(String... args) throws Exception {
		///////////// CASH APPROVED ////////////////
		CitizenPlan citizen1 = new CitizenPlan();
		citizen1.setCitizenName("Anish");
		citizen1.setGender(gender[0]);
		citizen1.setPlanName(PlanUtils.planOne);
		citizen1.setPlanStatus(PlanUtils.planStatusOne);
		citizen1.setPlanStartDate(LocalDate.now().minusDays(3));
		citizen1.setPlanEndDate(LocalDate.now().minusDays(3).plusMonths(6));
		citizen1.setBenefitAmount(5000);

		CitizenPlan citizen2 = new CitizenPlan();
		citizen2.setCitizenName("Anika");
		citizen2.setGender(gender[1]);
		citizen2.setPlanName(PlanUtils.planOne);
		citizen2.setPlanStatus(PlanUtils.planStatusOne);
		citizen2.setPlanStartDate(LocalDate.now().minusDays(10));
		citizen2.setPlanEndDate(LocalDate.now().plusMonths(6));
		citizen2.setBenefitAmount(10000);

		///////////// CASH DENIED ////////////////
		CitizenPlan citizen3 = new CitizenPlan();
		citizen3.setCitizenName("Ashok");
		citizen3.setGender(gender[0]);
		citizen3.setPlanName(PlanUtils.planOne);
		citizen3.setPlanStatus(PlanUtils.planStatusTwo);
		citizen3.setDenialRsn("Very high salary");

		CitizenPlan citizen4 = new CitizenPlan();
		citizen4.setCitizenName("Anjali");
		citizen4.setGender(gender[1]);
		citizen4.setPlanName(PlanUtils.planOne);
		citizen4.setPlanStatus(PlanUtils.planStatusTwo);
		citizen4.setDenialRsn("Candidate under government job benifit");

		///////////// Cash Terminated ////////////////////

		CitizenPlan citizen6 = new CitizenPlan();
		citizen6.setCitizenName("Ajay");
		citizen6.setGender(gender[0]);
		citizen6.setPlanName(PlanUtils.planOne);
		citizen6.setPlanStatus(PlanUtils.planStatusThree);
		citizen6.setPlanStartDate(LocalDate.now().minusWeeks(12));
		citizen6.setPlanEndDate(LocalDate.now().minusMonths(1));
		citizen6.setTerminatedDate(LocalDate.now().minusDays(10));
		citizen6.setTerminationRsn("Done fraud with the plan.");

		CitizenPlan citizen5 = new CitizenPlan();
		citizen5.setCitizenName("Preethi");
		citizen5.setGender(gender[1]);
		citizen5.setPlanName(PlanUtils.planOne);
		citizen5.setPlanStatus(PlanUtils.planStatusThree);
		citizen5.setPlanStartDate(LocalDate.now());
		citizen5.setPlanEndDate(LocalDate.now().plusMonths(8));
		citizen6.setTerminatedDate(LocalDate.now().plusMonths(6));
		citizen5.setTerminationRsn("Multiple benifits already taken.");

		///////////// Food Approved ////////////////////////////

		CitizenPlan citizen7 = new CitizenPlan();
		citizen7.setCitizenName("Rajeev");
		citizen7.setGender(gender[0]);
		citizen7.setPlanName(PlanUtils.planTwo);
		citizen7.setPlanStatus(PlanUtils.planStatusOne);
		citizen7.setPlanStartDate(LocalDate.now().minusWeeks(12));
		citizen7.setPlanEndDate(LocalDate.now().minusMonths(1));
		citizen7.setBenefitAmount(20000);

		CitizenPlan citizen8 = new CitizenPlan();
		citizen8.setCitizenName("Rani");
		citizen8.setGender(gender[1]);
		citizen8.setPlanName(PlanUtils.planTwo);
		citizen8.setPlanStatus(PlanUtils.planStatusOne);
		citizen8.setPlanStartDate(LocalDate.now().minusWeeks(12));
		citizen8.setPlanEndDate(LocalDate.now().plusDays(5));
		citizen8.setBenefitAmount(3000);

		///////////// Food DENIED ////////////////////////////

		CitizenPlan citizen9 = new CitizenPlan();
		citizen9.setCitizenName("Scott");
		citizen9.setGender(gender[0]);
		citizen9.setPlanName(PlanUtils.planTwo);
		citizen9.setPlanStatus(PlanUtils.planStatusTwo);
		citizen9.setDenialRsn("Over weight");

		CitizenPlan citizen10 = new CitizenPlan();
		citizen10.setCitizenName("Kathleen");
		citizen10.setGender(gender[1]);
		citizen10.setPlanName(PlanUtils.planTwo);
		citizen10.setPlanStatus(PlanUtils.planStatusTwo);
		citizen10.setDenialRsn("Already got food insurance under sports quota.");

		///////////// Food Terminated ////////////////////////////

		CitizenPlan citizen11 = new CitizenPlan();
		citizen11.setCitizenName("Jason");
		citizen11.setGender(gender[0]);
		citizen11.setPlanName(PlanUtils.planTwo);
		citizen11.setPlanStatus(PlanUtils.planStatusThree);
		citizen11.setPlanStartDate(LocalDate.now().minusWeeks(12));
		citizen11.setPlanEndDate(LocalDate.now().minusMonths(1));
		citizen11.setTerminatedDate(LocalDate.now().minusDays(6));
		citizen11.setTerminationRsn("Already had another insurance");

		CitizenPlan citizen12 = new CitizenPlan();
		citizen12.setCitizenName("Sugar");
		citizen12.setGender(gender[1]);
		citizen12.setPlanName(PlanUtils.planTwo);
		citizen12.setPlanStatus(PlanUtils.planStatusThree);
		citizen12.setPlanStartDate(LocalDate.now());
		citizen12.setPlanEndDate(LocalDate.now().plusMonths(8));
		citizen12.setTerminatedDate(LocalDate.now().plusMonths(5));
		citizen12.setTerminationRsn("Under family plan taking benifits.");

		///////////// Medical Approved ////////////////////////////

		CitizenPlan citizen13 = new CitizenPlan();
		citizen13.setCitizenName("Roy");
		citizen13.setGender(gender[0]);
		citizen13.setPlanName(PlanUtils.planThree);
		citizen13.setPlanStatus(PlanUtils.planStatusOne);
		citizen13.setPlanStartDate(LocalDate.now().minusWeeks(12));
		citizen13.setPlanEndDate(LocalDate.now().minusMonths(2));
		citizen13.setBenefitAmount(21000);

		CitizenPlan citizen14 = new CitizenPlan();
		citizen14.setCitizenName("Rati");
		citizen14.setGender(gender[1]);
		citizen14.setPlanName(PlanUtils.planThree);
		citizen14.setPlanStatus(PlanUtils.planStatusOne);
		citizen14.setPlanStartDate(LocalDate.now().minusWeeks(12));
		citizen14.setPlanEndDate(LocalDate.now().plusDays(22));
		citizen14.setBenefitAmount(5500);

		///////////// Medical DENIED ////////////////////////////

		CitizenPlan citizen15 = new CitizenPlan();
		citizen15.setCitizenName("John");
		citizen15.setGender(gender[0]);
		citizen15.setPlanName(PlanUtils.planThree);
		citizen15.setPlanStatus(PlanUtils.planStatusTwo);
		citizen15.setDenialRsn("CM Yojna.");

		CitizenPlan citizen16 = new CitizenPlan();
		citizen16.setCitizenName("Jazz");
		citizen16.setGender(gender[1]);
		citizen16.setPlanName(PlanUtils.planThree);
		citizen16.setPlanStatus(PlanUtils.planStatusTwo);
		citizen16.setDenialRsn("PM Yojan.");

		///////////// Food Terminated ////////////////////////////

		CitizenPlan citizen17 = new CitizenPlan();
		citizen17.setCitizenName("Jogger");
		citizen17.setGender(gender[0]);
		citizen17.setPlanName(PlanUtils.planThree);
		citizen17.setPlanStatus(PlanUtils.planStatusThree);
		citizen17.setPlanStartDate(LocalDate.now().minusWeeks(13));
		citizen17.setPlanEndDate(LocalDate.now().minusMonths(2));
		citizen17.setTerminatedDate(LocalDate.now().minusDays(4));
		citizen17.setTerminationRsn("Section 123");

		CitizenPlan citizen18 = new CitizenPlan();
		citizen18.setCitizenName("Sugar");
		citizen18.setGender(gender[1]);
		citizen18.setPlanName(PlanUtils.planThree);
		citizen18.setPlanStatus(PlanUtils.planStatusThree);
		citizen18.setPlanStartDate(LocalDate.now());
		citizen18.setPlanEndDate(LocalDate.now().plusMonths(9));
		citizen18.setTerminatedDate(LocalDate.now().plusMonths(4));
		citizen18.setTerminationRsn("Section 223");

		///////////// Employment Approved ////////////////////////////

		CitizenPlan citizen19 = new CitizenPlan();
		citizen19.setCitizenName("Ulvi");
		citizen19.setGender(gender[0]);
		citizen19.setPlanName(PlanUtils.planFour);
		citizen19.setPlanStatus(PlanUtils.planStatusOne);
		citizen19.setPlanStartDate(LocalDate.now().minusWeeks(20));
		citizen19.setPlanEndDate(LocalDate.now().plusDays(85));
		citizen19.setBenefitAmount(18000);

		CitizenPlan citizen20 = new CitizenPlan();
		citizen20.setCitizenName("Olga");
		citizen20.setGender(gender[1]);
		citizen20.setPlanName(PlanUtils.planFour);
		citizen20.setPlanStatus(PlanUtils.planStatusOne);
		citizen20.setPlanStartDate(LocalDate.now().minusWeeks(12));
		citizen20.setPlanEndDate(LocalDate.now().plusDays(45));
		citizen20.setBenefitAmount(12000);

		///////////// Medical DENIED ////////////////////////////

		CitizenPlan citizen21 = new CitizenPlan();
		citizen21.setCitizenName("Rahul");
		citizen21.setGender(gender[0]);
		citizen21.setPlanName(PlanUtils.planFour);
		citizen21.setPlanStatus(PlanUtils.planStatusTwo);
		citizen21.setDenialRsn("Relief Yojna.");

		CitizenPlan citizen22 = new CitizenPlan();
		citizen22.setCitizenName("Jizvi");
		citizen22.setGender(gender[1]);
		citizen22.setPlanName(PlanUtils.planFour);
		citizen22.setPlanStatus(PlanUtils.planStatusTwo);
		citizen22.setDenialRsn("Under Pension Yojan.");

		///////////// Food Terminated ////////////////////////////

		CitizenPlan citizen23 = new CitizenPlan();
		citizen23.setCitizenName("JaiKishan");
		citizen23.setGender(gender[0]);
		citizen23.setPlanName(PlanUtils.planFour);
		citizen23.setPlanStatus(PlanUtils.planStatusThree);
		citizen23.setPlanStartDate(LocalDate.now().minusWeeks(18));
		citizen23.setPlanEndDate(LocalDate.now().minusMonths(1));
		citizen23.setTerminatedDate(LocalDate.now().minusDays(2));
		citizen23.setTerminationRsn("Section 586");

		CitizenPlan citizen24 = new CitizenPlan();
		citizen24.setCitizenName("Priya");
		citizen24.setGender(gender[1]);
		citizen24.setPlanName(PlanUtils.planFour);
		citizen24.setPlanStatus(PlanUtils.planStatusThree);
		citizen24.setPlanStartDate(LocalDate.now());
		citizen24.setPlanEndDate(LocalDate.now().plusMonths(9));
		citizen24.setTerminatedDate(LocalDate.now().plusMonths(1));
		citizen24.setTerminationRsn("Section 858");

		List<CitizenPlan> plan = new ArrayList<>();
		plan.add(citizen1);
		plan.add(citizen2);
		plan.add(citizen3);
		plan.add(citizen4);
		plan.add(citizen5);
		plan.add(citizen6);
		plan.add(citizen7);
		plan.add(citizen8);
		plan.add(citizen9);
		plan.add(citizen10);

		plan.add(citizen11);
		plan.add(citizen12);
		plan.add(citizen13);
		plan.add(citizen14);
		plan.add(citizen15);
		plan.add(citizen16);
		plan.add(citizen17);
		plan.add(citizen18);
		plan.add(citizen19);
		plan.add(citizen20);

		plan.add(citizen21);
		plan.add(citizen22);
		plan.add(citizen23);
		plan.add(citizen24);

		//repoObj.saveAll(plan);
		

	}

	public String[] getGender() {
		return gender;
	}

}
