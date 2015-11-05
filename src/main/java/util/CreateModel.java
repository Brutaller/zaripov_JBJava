package util;

import model.MedClinic;
import model.Office;
import model.Provider;
import service.MedClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class CreateModel {

    @Autowired
    private MedClinicService medClinicService;

    public Model createModel(Model model, Provider provider, MedClinic medClinic, Office office) {
        if (medClinic.getName() == null) {
            model.addAttribute("medClinicNames", medClinicService.getMedClinicNames());
        } else if (office.getCity() == null) {
            model.addAttribute("medClinicName", medClinic.getName());
            model.addAttribute("cities", medClinicService.getMedClinicCities(medClinic.getName()));
        } else if (office.getStreet() == null) {
            model.addAttribute("medClinicName", medClinic.getName());
            model.addAttribute("streets", medClinicService.getStreetsOfOfficeInCityOfMedClinic(medClinic.getName(), office.getCity()));
            model.addAttribute("city", office.getCity());
        } else {
            model.addAttribute("medClinicName", medClinic.getName());
            model.addAttribute("providers", medClinicService.getProvidersOffice(medClinic.getName(), office.getCity(), office.getStreet()));
            model.addAttribute("city", office.getCity());
            System.out.println((office.getCity()));
            model.addAttribute("street", office.getStreet());
        }
        return model;
    }
}
