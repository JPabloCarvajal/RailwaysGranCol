/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.model;

import upb.sgttp.model.domain.persons.Admin;
import upb.sgttp.model.domain.persons.Contact;
import upb.sgttp.model.domain.persons.Customer;
import upb.sgttp.model.domain.persons.Employee;
import upb.sgttp.shared.textfilewriter.TextFileWriter;

/**
 *
 * @author thewe
 */
public class TraceabilityModel {

    private static TextFileWriter writer = new TextFileWriter("src\\main\\java\\upb\\sgttp\\database\\traceability.txt");

    public static void writeTraceability(String traceability) {
        String text = "";
        switch (AuthenticationModel.getUserLogin().getType()) {
            case 0 -> {
                Employee employee = (Employee) AuthenticationModel.getUserLogin().getPerson();
                text = "ID: "+employee.getId()+" "+traceability;
            }
            case 1 -> {
                Customer customer = (Customer) AuthenticationModel.getUserLogin().getPerson();
                text = "ID: "+customer.getCustomerId()+" "+traceability;
            }
            case 2 -> {
                Contact contact = (Contact) AuthenticationModel.getUserLogin().getPerson();
                text = "ID: "+contact.getContactId()+" "+traceability;
            }
            case 3 -> {
                Admin admin = (Admin) AuthenticationModel.getUserLogin().getPerson();
                text = "ID: "+admin.getId()+" "+traceability;
            }
        }
        writer.agregarTexto(text);
    }
}
