package com.skill.India.POC;

import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 * Created by Alkesh srivastav on 7/4/2017.
 */
public class CreatePdf {

    public static void main(String args[]){
        new CreatePdf();
    }

    public CreatePdf(){
        build();
    }

    public void build(){
        try {
            report().columns(
                    col.column("Item", "item", type.stringType()),
                    col.column("Quantity", "quantity", type.integerType()),
                    col.column("Location", "location", type.stringType()),
                    col.column("Country", "country", type.stringType())
            )
                    .title(cmp.text("Sample Pdf"))
                    .pageFooter(cmp.pageNumber())
                    .setDataSource(createDatasource())
                    .toPdf(new FileOutputStream("test.pdf"));
                    //.show();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        catch (DRException e){
            e.printStackTrace();
        }
    }

    private JRDataSource createDatasource() {

        DRDataSource dataSource = new DRDataSource("item","quantity","location", "country");
        //The following datasource can be configured dynamically too using Beans
        //Until then the data is being populated statically
        for (int x=0; x<50; x++){
            dataSource.add("Notebooks", 102, "NOIDA", "India");
            dataSource.add("Bottles", 55, "Delhi", "India");
            dataSource.add("Vase", 12, "Ghaziabad", "India");
            dataSource.add("Pencil", 1522, "Gurgaon", "India");
        }
        return dataSource;
    }
}
