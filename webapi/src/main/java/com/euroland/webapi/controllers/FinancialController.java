package com.euroland.webapi.controllers;

import com.euroland.webapi.helpers.SequenceHelper;
import com.euroland.webapi.models.Financial;
import com.euroland.webapi.repositories.IFinancialRepository;
import euroland.ai.service.CommandArgumentModelLocator;
import euroland.ai.service.CommandFinancialArgumentClassifier;
import jmdn.base.util.string.StrUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/financials")
public class FinancialController {
    private final String DATE_TIME_FORMAT="yyyy-MM-dd";
    private IFinancialRepository financialRepository;

    public FinancialController(IFinancialRepository financialRepository) {
        this.financialRepository = financialRepository;
    }

    @GetMapping("/all")
    public List<Financial> getAll(){
        List<Financial> financials = this.financialRepository.findAll();
        return  financials;
    }

    @PutMapping
    public void insert(@RequestBody Financial financial){
        this.financialRepository.insert(financial);
    }

    @PostMapping
    public void update(@RequestBody Financial financial){
        this.financialRepository.save(financial);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable("id") String id){
        this.financialRepository.delete(id);
    }

    @GetMapping("/{name}")
    public Financial getByName(@PathVariable("name") String name){
        Financial financial = this.financialRepository.findByName(name);
        return financial;
    }

    @GetMapping("/financial/{name}/{year}")
    public Financial getByNameAndDate(@PathVariable("name") String name, @PathVariable("year")String year){
        Financial financial = this.financialRepository.findByNameAndDateTime(name,year);
        return financial;
    }

    @GetMapping("/financial/{name}/{year}/{company}")
    public Financial getByNameAndDateAndCompany(@PathVariable("name") String name, @PathVariable("year")String year, @PathVariable("company") String company){
        Financial financial = this.financialRepository.findByNameAndDateCompanyName(name,year,company);
        return financial;
    }

    @GetMapping("/company/{name}")
    public List<Financial> getByCompany(@PathVariable("name") String name){
        List<Financial> financials = this.financialRepository.findByCompany(name);
        return financials;
    }

    @GetMapping("/ask/{question}")
    public List<String> getAnswer(@PathVariable("question") String question){
        double result = 0;
        List<String> answers = new ArrayList<String>();
        String answer = "";
        String message = "";
        String originQuestion = question;
        String tagLabeled = "";
        String argumentAspect = "";
        String argumentOrganization = "";
        String argumentDateTime = "";
        String argumentOrder = "";
        String argumentIntend = "";
        String argumentOperator = "";

        if (question != null && !question.isEmpty()) {
            // normalize question
            question = StrUtil.normalizeString(question);

            // initialize command argument classifier
            CommandFinancialArgumentClassifier commandArgumentClassifier = new CommandFinancialArgumentClassifier(
                    CommandArgumentModelLocator.getModelLocation("commandFinnancialArgumentClassificationModel"));
            commandArgumentClassifier.init();

            // do classification the question
            List<String> tags = commandArgumentClassifier.doCommandArgumentClassification(question);

            // display the labeled which is recognized by the model
            tagLabeled = StrUtil.join(tags);

            // processing arguments
            if (tags.size() > 0) {
                String defaultOrganization = "CARLSBERG";

                String aspect = SequenceHelper.getAspect(question, tags);
                String datetime = SequenceHelper.getDatetimePhrase(question, tags);
                String organizationName = SequenceHelper.getOrganizationName(question, tags);
                String order = SequenceHelper.getOrder(question, tags);
                String intend = SequenceHelper.getIntend(question, tags);
                String operator = SequenceHelper.getOperator(question, tags);

                argumentAspect="aspect: "+aspect;
                argumentOrganization="organization: "+organizationName;
                argumentDateTime ="datetime: "+datetime;
                argumentOrder = "order: "+order;
                argumentIntend = "intend: "+intend;
                argumentOperator = "operator: "+operator;

                if(organizationName == null || organizationName.isEmpty()){
                    organizationName = defaultOrganization;
                }
                if(aspect == null || aspect.isEmpty()) {
                    message = "Your question is pretty general. Please enter the question a little bit more specific.";
                }
                else {
                    if(datetime == null || datetime.isEmpty()){
                        message = "What is period you want to know about the " + aspect;
                    }
                    else {

                        Financial financial = this.financialRepository.findByNameAndDateCompanyName(aspect, datetime,organizationName);
                        if (financial!=null){
                            answer = "The "+ aspect+" in "+datetime+ " is: "+ financial.getFinancialDetails().get(0).getFinancialValue();
                        }
                    }
                }
            }

        } else {
            message = "No question available!";
        }


        answers.add(originQuestion);
        answers.add(argumentAspect);
        answers.add(argumentOrganization);
        answers.add(argumentDateTime);
        answers.add(argumentOrder);
        answers.add(argumentIntend);
        answers.add(argumentOperator);
        answers.add(answer);
        answers.add(message);

        return answers;
    }
}
