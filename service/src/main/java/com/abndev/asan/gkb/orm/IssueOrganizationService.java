package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.DocumentTypeDict;
import com.abndev.asan.gkb.dom.dict.IssueOrganizationDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IssueOrganizationService {
    @Autowired
    private IssueOrganizationRepo issueOrganizationRepo;

    public IssueOrganizationDict update(IssueOrganizationDict issueOrganization) {
        Optional<IssueOrganizationDict> foundOpt = issueOrganizationRepo.findById(issueOrganization.getCode());
        if (!foundOpt.isPresent()) {
            IssueOrganizationDict savedType = issueOrganizationRepo.saveAndFlush(issueOrganization);
            return savedType;
        }
        return issueOrganization;
    }
}
