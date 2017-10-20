package com.euroland.webapi;

import com.euroland.webapi.models.Company;
import com.euroland.webapi.models.Financial;
import com.euroland.webapi.models.FinancialDetail;
import com.euroland.webapi.repositories.IFinancialRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner{

    private IFinancialRepository financialRepository;

    public DbSeeder(IFinancialRepository financialRepository) {
        this.financialRepository = financialRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        String dateTimeFormat="yyyy-MM-dd";
        String dateTime1="2012";
        String dateTime2="2013";
        String dateTime3="2014";
        String dateTime4="2015";
        String dateTime5="2016";

        Financial revenue = new Financial(
                "Revenue",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                    new FinancialDetail(67201,dateTime1),
                    new FinancialDetail(66552,dateTime2),
                    new FinancialDetail(64506,dateTime3),
                    new FinancialDetail(65354,dateTime4),
                    new FinancialDetail(62614,dateTime5)
                )
        );

        Financial costOfRevenue = new Financial(
                "Cost of Revenue",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(33831,dateTime1),
                        new FinancialDetail(33622,dateTime2),
                        new FinancialDetail(32725,dateTime3),
                        new FinancialDetail(33429,dateTime4),
                        new FinancialDetail(31195,dateTime5)
                )
        );


        Financial grossOperatingProfit = new Financial(
                "Gross Operating Profit",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(33370,dateTime1),
                        new FinancialDetail(32930,dateTime2),
                        new FinancialDetail(31781,dateTime3),
                        new FinancialDetail(31925,dateTime4),
                        new FinancialDetail(31419,dateTime5)
                )
        );

        Financial salesGeneralAndAdministrative = new Financial(
                "Sales, general and administrative",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(23830,dateTime1),
                        new FinancialDetail(23219,dateTime2),
                        new FinancialDetail(23328,dateTime3),
                        new FinancialDetail(24067,dateTime4),
                        new FinancialDetail(3696,dateTime5)
                )
        );

        Financial otherOperatingExpenses = new Financial(
                "Other Operating Expenses",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(-253,dateTime1),
                        new FinancialDetail(-133,dateTime2),
                        new FinancialDetail(-777,dateTime3),
                        new FinancialDetail(-599,dateTime4),
                        new FinancialDetail(-522,dateTime5)
                )
        );

        Financial totalOperatingExpenses = new Financial(
                "Total Operating Expenses",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(23577,dateTime1),
                        new FinancialDetail(23086,dateTime2),
                        new FinancialDetail(22551,dateTime3),
                        new FinancialDetail(23468,dateTime4),
                        new FinancialDetail(23174,dateTime5)
                )
        );

        Financial operatingIncomeBeforeInterestAndTaxes = new Financial(
                "Operating income before interest and taxes",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(9793,dateTime1),
                        new FinancialDetail(9844,dateTime2),
                        new FinancialDetail(9230,dateTime3),
                        new FinancialDetail(8457,dateTime4),
                        new FinancialDetail(8245,dateTime5)
                )
        );

        Financial nonOperatingIncome = new Financial(
                "Non-operating income",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(-1687,dateTime1),
                        new FinancialDetail(-1999,dateTime2),
                        new FinancialDetail(-2544,dateTime3),
                        new FinancialDetail(-10190,dateTime4),
                        new FinancialDetail(-966,dateTime5)
                )
        );

        Financial incomeBeforeIncomeTaxes = new Financial(
                "Income before income taxes",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(8106,dateTime1),
                        new FinancialDetail(7845,dateTime2),
                        new FinancialDetail(6686,dateTime3),
                        new FinancialDetail(-1733,dateTime4),
                        new FinancialDetail(7249,dateTime5)
                )
        );

        Financial provisionForIncomeTaxes = new Financial(
                "Provision for income taxes",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(1861,dateTime1),
                        new FinancialDetail(1894,dateTime2),
                        new FinancialDetail(1748,dateTime3),
                        new FinancialDetail(849,dateTime4),
                        new FinancialDetail(2392,dateTime5)
                )
        );

        Financial netIncomeFromContinuingOperations = new Financial(
                "Net income from continuing operations",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(6245,dateTime1),
                        new FinancialDetail(5951,dateTime2),
                        new FinancialDetail(4938,dateTime3),
                        new FinancialDetail(-2582,dateTime4),
                        new FinancialDetail(4857,dateTime5)
                )
        );

        Financial netIncome = new Financial(
                "Net Income",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(5607,dateTime1),
                        new FinancialDetail(5471,dateTime2),
                        new FinancialDetail(4414,dateTime3),
                        new FinancialDetail(-2926,dateTime4),
                        new FinancialDetail(4486,dateTime5)
                )
        );

        Financial netIncomeAvailableForCommonShareholders = new Financial(
                "Net income available for common shareholders",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(5607,dateTime1),
                        new FinancialDetail(5471,dateTime2),
                        new FinancialDetail(4414,dateTime3),
                        new FinancialDetail(-2926,dateTime4),
                        new FinancialDetail(4486,dateTime5)
                )
        );


        Financial cashAndCashEquivalents = new Financial(
                "Cash and cash equivalents",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(5760,dateTime1),
                        new FinancialDetail(3714,dateTime2),
                        new FinancialDetail(2418,dateTime3),
                        new FinancialDetail(3131,dateTime4),
                        new FinancialDetail(3502,dateTime5)
                )
        );

        Financial shortTermInvestments = new Financial(
                "Short-term investments",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(21,dateTime1),
                        new FinancialDetail(0,dateTime2),
                        new FinancialDetail(0,dateTime3),
                        new FinancialDetail(0,dateTime4),
                        new FinancialDetail(0,dateTime5)
                )
        );

        Financial totalCashCashEquivalentsAndShortTermInvestments = new Financial(
                "Total cash, cash equivalents, and short-term investments",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(5781,dateTime1),
                        new FinancialDetail(3714,dateTime2),
                        new FinancialDetail(2418,dateTime3),
                        new FinancialDetail(3131,dateTime4),
                        new FinancialDetail(3502,dateTime5)
                )
        );

        Financial grossMargin = new Financial(
                "Gross Margin",
                new Company("CARLSBERG","DKK","Copenhagen","Denmark"),
                Arrays.asList(
                        new FinancialDetail(4966,dateTime1),
                        new FinancialDetail(4948,dateTime2),
                        new FinancialDetail(4927,dateTime3),
                        new FinancialDetail(4885,dateTime4),
                        new FinancialDetail(5018,dateTime5)
                )
        );

        // drop all financials
        this.financialRepository.deleteAll();

        // add our financials to the database
        List<Financial> financials = Arrays.asList(revenue,costOfRevenue,grossOperatingProfit,
                salesGeneralAndAdministrative,otherOperatingExpenses,totalOperatingExpenses,
                operatingIncomeBeforeInterestAndTaxes,nonOperatingIncome,incomeBeforeIncomeTaxes,
                provisionForIncomeTaxes,netIncomeFromContinuingOperations,netIncome,netIncomeAvailableForCommonShareholders,
                cashAndCashEquivalents,shortTermInvestments,totalCashCashEquivalentsAndShortTermInvestments,grossMargin);

        // save all the data to database
        this.financialRepository.save(financials);

    }
}
