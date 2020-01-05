package com.telran.runner;

import com.telran.entity.CompanyDetails;
import com.telran.entity.Job;
import com.telran.repository.CompanyDetailsRepository;
import com.telran.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartRunner implements ApplicationRunner {

    private final JobRepository jobRepository;
    private final CompanyDetailsRepository companyDetailsRepository;

    @Autowired
    public StartRunner(JobRepository jobRepository, CompanyDetailsRepository companyDetailsRepository) {
        this.jobRepository = jobRepository;
        this.companyDetailsRepository = companyDetailsRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        jobRepository.deleteAll();

        CompanyDetails companyDetails = CompanyDetails.builder()
                .companyCity("Tel-Aviv")
                .companyDescription("We're the leaders of the market, started 15 years ago from a small startup to a huge international company with 100500 representatives throughout the world")
                .startedSinceYear(2005)
                .build();

        //companyDetails = null
        Job job = Job.builder()
                .companyDetails(null)
                .description("We're looking for a passionate software developer, who can work for just food, but have to pay at least 15-18K money in order to get someone")
                .language("Java")
                .language("C#")
                .language("javaScript")
                .language("Ruby On Rails")
                .language("HTML")
                .language("English")
                .language("Ktulhu")
                .minYearsOfExperience(10)
                .build();

        jobRepository.save(job);

        companyDetailsRepository.save(companyDetails);

        //СБЫЛОСЬ       - companyDetails.id != null
        //НЕ СБЫЛОСЬ    - job.companyDetails - как ссылка, а не целый объект (а не embedded)


        job.setCompanyDetails(companyDetails);
        job.setId(null); //insert | update
        jobRepository.save(job);

    }
}
