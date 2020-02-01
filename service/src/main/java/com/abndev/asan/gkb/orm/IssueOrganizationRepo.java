package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.IssueOrganizationDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueOrganizationRepo extends JpaRepository<IssueOrganizationDict, String> {
}
