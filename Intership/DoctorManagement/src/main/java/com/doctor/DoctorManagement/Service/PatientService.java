package com.doctor.DoctorManagement.Service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.doctor.DoctorManagement.Model.Doctor;
import com.doctor.DoctorManagement.Model.Patient;
import com.doctor.DoctorManagement.Model.Speciality;
import com.doctor.DoctorManagement.Model.Symptoms;
import com.doctor.DoctorManagement.Repository.IDoctorRepository;
import com.doctor.DoctorManagement.Repository.IPatientRepository;
import com.doctor.DoctorManagement.Repository.ISymptomsRepository;
import com.doctor.DoctorManagement.Utils.PatientUtil;

@Service
public class PatientService {

	@Autowired
	private PatientUtil patientUtil;

	@Autowired
	private IDoctorRepository iDoctorRepository;

	@Autowired
	private IPatientRepository iPatientRepository;

	@Autowired
	private ISymptomsRepository iSymptomsRepository;

	public ResponseEntity<String> createPatient(String patient) {
		JSONObject patientJsonObject = new JSONObject(patient);
		JSONObject isValidJsonObject = patientUtil.isValid(patientJsonObject);
		if (isValidJsonObject.isEmpty()) {
			Patient patient1 = patientUtil.setPatient(patientJsonObject);
			iPatientRepository.save(patient1);
			return new ResponseEntity<String>("Patient is created", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(isValidJsonObject.toString(), HttpStatus.BAD_REQUEST);
		}

	}

	public ResponseEntity<String> getDoctor(String getDoctor) {
		JSONObject jsonObject = new JSONObject(getDoctor);
		String city = jsonObject.getString("city");
		List<Doctor> listofDoctors = iDoctorRepository.findByCity(city);
		if (listofDoctors.isEmpty()) {
			return new ResponseEntity<String>("We still waiting to expand to your location", HttpStatus.NOT_FOUND);
		} 
		else {
			JSONArray jsonarry = jsonObject.getJSONArray("symptom");
			String sym = jsonarry.getString(0);
			List<Symptoms> list = iSymptomsRepository.findBySymptom(sym);
			if (!list.isEmpty()) {
				int id = list.get(0).getSpeciality().getId();
				List<Doctor> listofDoctors2 = iDoctorRepository.findByCityAndSpe(id, city);
				if (!listofDoctors2.isEmpty()) {
					return new ResponseEntity<String>(listofDoctors2.toString(), HttpStatus.OK);
				} else {
					return new ResponseEntity<String>("There isn’t any doctor present at your location for your symptom",
							HttpStatus.NOT_FOUND);
				}
			}
			return null;
		}

	}

	public ResponseEntity<String> deletePatient(int id) {
		if(!iPatientRepository.findById(id).isEmpty()) {
			iPatientRepository.deleteByDoctor(id);
			return new ResponseEntity<String>("Patient Deleted ",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Patient id not found ",HttpStatus.OK);
	}

	public ResponseEntity<String> suggestDoctor(int id) {
		Patient patient=iPatientRepository.findById(id).get(0);
		String city=patient.getCity();
		List<String> symptom=patient.getSymptom();
		String sym=symptom.get(0);
		List<Symptoms> list = iSymptomsRepository.findBySymptom(sym);
		int id1 = list.get(0).getSpeciality().getId();
		List<Doctor> listofDoctors = iDoctorRepository.findByCityAndSpe(id1, city);
		JSONArray jsonArray=new JSONArray();
		if(!listofDoctors.isEmpty()) {
			for(Doctor doctor:listofDoctors) {
				JSONObject jsonObject=patientUtil.setDoctor(doctor);
				jsonArray.put(jsonObject);
			}
			return new ResponseEntity<String>(jsonArray.toString(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("There isn’t any doctor present at your location for your symptom",
					HttpStatus.NOT_FOUND);
		}
				
	}
	
	

}
