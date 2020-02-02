package com.abndev.asan.gkb.soap;

import com.abndev.asan.gkb.dom.BirthPlace;
import com.abndev.asan.gkb.dom.CertificateBirth;
import com.abndev.asan.gkb.dom.CertificateDeath;
import com.abndev.asan.gkb.dom.DataObject;
import com.abndev.asan.gkb.dom.Document;
import com.abndev.asan.gkb.dom.Documents;
import com.abndev.asan.gkb.dom.PersonInfo;
import com.abndev.asan.gkb.dom.PersonObject;
import com.abndev.asan.gkb.dom.PersonResponse;
import com.abndev.asan.gkb.dom.ResponseInfo;
import com.abndev.asan.gkb.dom.dict.CitizenshipDict;
import com.abndev.asan.gkb.dom.dict.CountryDict;
import com.abndev.asan.gkb.dom.dict.DistrictDict;
import com.abndev.asan.gkb.dom.dict.DocumentStatusDict;
import com.abndev.asan.gkb.dom.dict.DocumentTypeDict;
import com.abndev.asan.gkb.dom.dict.GenderDict;
import com.abndev.asan.gkb.dom.dict.IssueOrganizationDict;
import com.abndev.asan.gkb.dom.dict.LifeStatusDict;
import com.abndev.asan.gkb.dom.dict.NationalityDict;
import com.abndev.asan.gkb.dom.dict.RegionDict;
import com.abndev.asan.gkb.orm.BirthCertificateService;
import com.abndev.asan.gkb.orm.CitizenshipService;
import com.abndev.asan.gkb.orm.CountryService;
import com.abndev.asan.gkb.orm.DataObjectRepo;
import com.abndev.asan.gkb.orm.DeathCertificateService;
import com.abndev.asan.gkb.orm.DistrictService;
import com.abndev.asan.gkb.orm.DocumentStatusService;
import com.abndev.asan.gkb.orm.DocumentTypeService;
import com.abndev.asan.gkb.orm.GenderService;
import com.abndev.asan.gkb.orm.IssueOrganizationService;
import com.abndev.asan.gkb.orm.LifeStatusService;
import com.abndev.asan.gkb.orm.NationalityService;
import com.abndev.asan.gkb.orm.PersonInfoService;
import com.abndev.asan.gkb.orm.RegionService;
import com.abndev.asan.gkb.orm.ResponseInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;


@Service
public class PersonService {

    @Autowired
    private ResponseInfoRepo responseInfoRepo;
    @Autowired
    private DataObjectRepo dataObjectRepo;
    @Autowired
    private DocumentTypeService documentTypeService;
    @Autowired
    private IssueOrganizationService issueOrganizationService;
    @Autowired
    private DocumentStatusService documentStatusService;
    @Autowired
    private GenderService genderService;
    @Autowired
    private NationalityService nationalityService;
    @Autowired
    private CitizenshipService citizenshipService;
    @Autowired
    private LifeStatusService lifeStatusService;
    @Autowired
    private DeathCertificateService deathCertificateService;
    @Autowired
    private BirthCertificateService birthCertificateService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private PersonInfoService personInfoService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void store(PersonResponse response) {

        PersonObject personObject = response.getReturnObject().getPersonObject();

        // ResponseInfo
        ResponseInfo responseInfo = (ResponseInfo) personObject.getResponseInfo();
        responseInfoRepo.save(responseInfo);

        //
        DataObject data = personObject.getResponseData().getDataObject();

        // Persons
        List<PersonInfo> personCollection = data.getPersons().getPersonInfos();
        // TODO check NULL ?
        if (CollectionUtils.isEmpty(personCollection)) {
            throw new RuntimeException("Person not present.");
        }
        PersonInfo personInfo = data.getPersons().getPersonInfos().get(0);
        data.getPersons().setInn(personInfo.getIin());

        // Gender
        if (personInfo.getGender() != null) {
            GenderDict gender = genderService.update(personInfo.getGender());
            personInfo.setGender(gender);
        }

        // Nationality
        if (personInfo.getNationality() != null) {
            NationalityDict nationality = nationalityService.update(personInfo.getNationality());
            personInfo.setNationality(nationality);
        }

        // citizenship
        if (personInfo.getCitizenship() != null) {
            CitizenshipDict citizenship = citizenshipService.update(personInfo.getCitizenship());
            personInfo.setCitizenship(citizenship);
        }

        // LifeStatus
        if (personInfo.getLifeStatus() != null) {
            LifeStatusDict lifeStatus = lifeStatusService.update(personInfo.getLifeStatus());
            personInfo.setLifeStatus(lifeStatus);
        }

        // DeathCertificate
        if (personInfo.getDeathCertificate() != null) {
            CertificateDeath certificateDeath = deathCertificateService.update(personInfo.getDeathCertificate());
            personInfo.setDeathCertificate(certificateDeath);
        }

        // BirthCertificate
        if (personInfo.getBirthCertificate() != null) {
            CertificateBirth certificateBirth = birthCertificateService.update(personInfo.getBirthCertificate());
            personInfo.setBirthCertificate(certificateBirth);
        }

        // BirthPlace
        BirthPlace birthPlace = personInfo.getBirthPlace();
        if (birthPlace.getCountry() != null) {
            CountryDict country = countryService.update(birthPlace.getCountry());
            birthPlace.setCountry(country);
        }
        if (birthPlace.getDistrict() != null) {
            DistrictDict districtDict = districtService.update(birthPlace.getDistrict());
            birthPlace.setDistrict(districtDict);
        }
        if (birthPlace.getRegion() != null) {
            RegionDict regionDict = regionService.update(birthPlace.getRegion());
            birthPlace.setRegion(regionDict);
        }

        // Documents
        Documents documents = personInfo.getDocuments();
        Set<Document> documentCollection = documents.getDocuments();
        documentCollection.forEach(doc -> {
            // DcoType
            if (doc.getType() != null) {
                DocumentTypeDict docType = documentTypeService.update(doc.getType());
                doc.setType(docType);
            }

            // IssOrg
            if (doc.getIssueOrganization() != null) {
                IssueOrganizationDict issOrgUpdated =
                        issueOrganizationService.update(doc.getIssueOrganization());
                doc.setIssueOrganization(issOrgUpdated);
            }

            // DocStatus
            if (doc.getStatus() != null) {
                DocumentStatusDict docStatusUpdated = documentStatusService.update(doc.getStatus());
                doc.setStatus(docStatusUpdated);
            }
        });

        // PersonInfo
        if (personInfo != null) {
            PersonInfo pi = personInfoService.update(personInfo);
            personCollection.remove(personInfo);
            personCollection.add(pi);
        }

        dataObjectRepo.save(data);
    }
}
