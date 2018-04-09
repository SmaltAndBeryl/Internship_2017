
/* DROP schema */

drop database if exists scgj;

/*  create schema */

create database if not exists scgj;
use scgj;
/* DROP tables */

drop table if exists user;
drop table if exists application;
drop table if exists trainingPartnerRegistration;
drop table if exists tpManagement;
drop table if exists assessmentAgencyRegistration;
drop table if exists abManagement;
drop table if exists abAssessor;
drop table if exists tpTrainer;
drop table if exists csvUploaded;
drop table if exists businessAudit;
drop table if exists trainingPartner;
drop table if exists documentsUploaded;
drop table if exists applicationcomments;
drop table if exists centre;
drop table if exists trainer;
drop table if exists agency;
drop table if exists assessor;
drop table if exists employer;
drop table if exists batch;
drop table if exists showinterest;
drop table if exists batchassignment;
drop table if exists certificate;
drop table if exists candidate;
drop table if exists TrainingPartnerOrganizationDetails;
drop table if exists TrainingPartnerCenterLevelDetails;
drop table if exists TrainingPartnerInstituteGrant;
drop table if exists TrainingPartnerInstituteRecognition;
drop table if exists TrainingPartnerPriorExperienceInSkillTraining;
drop table if exists TrainingPartnerManagementAndStaffAndOfficialsDetails;
drop table if exists AssessmentBodyRegistrationDetails;
drop table if exists AssessmentBodyRecognitions;
drop table if exists AssessmentsExperienceInTechnicalDomain;
drop table if exists AssessmentBodyDirectorsAndManagementTeamDetails;
drop table if exists AssessmentStaffDetails;
drop table if exists AssessmentBodyRegionalOfficeDetails;
drop table if exists AssessmentBodyAffiliationDetails;


/* create table for user */

CREATE TABLE if not exists user (
  organizationName varchar(200) unique key not null,
  sPOCName varchar(200),
 userId varchar(200) unique key not null,
  password varchar(30) not null,
  userRole varchar(20) not null,
  userStatus varchar(15) not NULL,
  Id int(10) primary key AUTO_INCREMENT);

 /* create table for application */
 
create table if not exists application(
applicationId int(20) auto_increment Primary key not null,
applicationState varchar(20) not null,
activeFlag boolean,
dateOfSubmission datetime not null,
userId varchar(200) , 
foreign key (userId) references user(userId));


/* create table for csvUploaded */

create table if not exists csvUploaded(
csvId int(10) auto_increment Primary key,
csvType varchar(30) not null,
csvName varchar(200) not null,
csvUploadDate date,
csvUploadUserId varchar(200) not null,
foreign key (csvUploadUserId)
 references user(userId));
 
 /* create table for businessAudit */

create table if not exists businessAudit(
auditId int(10) primary key auto_increment,
auditMessage varchar(500) not null,
 userId varchar(200) not null,
 foreign key (userId) references user(userId));
 
 /* create table for trainingPartner */

create table if not exists trainingPartner(
trainingPartnerId varchar(20) primary key,
trainingPartnerName varchar(200) not null,
applicationId int(20) not null,
foreign key (applicationId) references application(applicationId));

 /* create table for documentsUploaded */

create table if not exists documentsUploaded(
documentId int(10) primary key auto_increment,
documentName varchar(200) not null,
documentLocation varchar(150),
applicationId int(20) not null,
foreign key (applicationId) references application(applicationId));

/* create table for applicationComments */

create table if not exists applicationComments(
commentId int(10) primary key auto_increment,
comment varchar(200) not null,
applicationId int(20) not null,
activeFlag boolean,
foreign key (applicationId) references application(applicationId));

/* create table for centre */

create table if not exists centre(
centreId int(5) primary key,
centreName varchar(200) not null,
centrePOCContactName varchar(200) not null,
centreAddress varchar(500) not null,
district varchar(50) not null,
state varchar(50) not null,
trainingPartnerId varchar(20) not null,
foreign key (trainingPartnerId) references trainingPartner(trainingPartnerId));

/* create table for trainer */

create table if not exists trainer(
trainerId int(10) primary key,
trainerName varchar(200) not null,
designation varchar(200) not null,
trainingPartnerId varchar(20) not null,
foreign key (trainingPartnerId)
 references trainingPartner(trainingPartnerId ));

/* create table for agency */

create table if not exists agency(
agencyId int(10) primary key,
agencyName varchar(200) not null,
applicationId int(20) not null,
foreign key (applicationId)
 references application(applicationId));

/* create table for assessor */

create table if not exists assessor(
assessorId int(10) primary key,
assessorName varchar(200) not null,
district varchar(50) not null,
 state varchar(50) not null,
agencyId int(10) not null,
foreign key (agencyId)
 references agency(agencyId));

/* create table for employer */

create table if not exists employer(
employerId int(10) primary key,
employerName varchar(200) not null,
locationOfEmployer varchar(500) not null,
locationOfEmployerDistrict varchar(50) not null,
locationOfEmployerState varchar(50));

/* create table for batch */

create table if not exists batch(
Id int(10) primary key AUTO_INCREMENT,
batchId varchar(200) unique key not null,
batchName varchar(200) not null,
batchType varchar(10) not null,
trainingPartnerId varchar(20) not null,
centreId int(5) not null,
trainerId int(10),
totalCandidatesInBatch int(5) not null,
batchStartDate date not null,
batchEndDate date not null,
jobRole varchar(100) not null,
jobRoleCode varchar(30) ,
maximumMarksTheory decimal(5,2),
maximumMarksPractical decimal(5,2),
level int(5) ,
resultApproved varchar(15),
resultApprovedOnDate date,
totalPass int(5),
totalFail int(5),
totalNotAppeared int(5),
totalCertified int(5),
batchAssignmentDate date,
assessmentDate date not null,
agencyId int(10),
assessorId int(10),
batchMode varchar(50) not null,
foreign key (trainingPartnerId) references trainingPartner(trainingPartnerId),
foreign key (centreId) references centre(centreId),
foreign key (trainerId) references trainer(trainerId),
foreign key (agencyId) references agency(agencyId),
foreign key (assessorId) references assessor(assessorId));

/* create table for showInterest */

create table if not exists showInterest(
showIntrestId int(10) primary key auto_increment,
batchId varchar(200),
agencyId int(10),
timeStamp timestamp,
foreign key (batchId) references batch(batchId),
foreign key (agencyId) references agency(agencyId));

/* create table for batchAssignment */

create table if not exists batchAssignment(
batchAssignmentid int(10) primary key auto_increment,
batchId varchar(200),
agencyId int(10),
timeStamp timestamp,
responseType varchar(20),
foreign key (batchId) references batch(batchId),
foreign key (agencyId) references agency(agencyId));

/* create table for certificate */

create table if not exists certificate(
certificateId int(10) primary key auto_increment,
certificateName varchar(50),
certificateUploadDate date,
batchId varchar(200),
userId varchar(200),
foreign key (batchId) references batch(batchId),
foreign key (userId) references user(userId));

/* create table for candidate */

create table if not exists candidate(
Id int(10) primary key AUTO_INCREMENT,
candidateDetailsId varchar(200) unique key not null,
candidateName varchar(200) not null,
enrollmentNumber varchar(40) null,
gender varchar(6) not null,
dateOfBirth date null,
nameOfFatherOrHusband varchar(200) null,
aadharNumber bigint(12) null,
mobileNumber bigint(11) null,
emailId varchar(200) null,
educationLevel varchar(50) null,
traineeAddress varchar(500) null,
traineePinCode int(6) null,
marksObtainedTheory decimal(5,2) null,
marksObtainedPractical decimal(5,2) null,
result varchar(20) null,
certified varchar(5) null,
placementStatus varchar(20) null,
dateOfJoining date null,
employmentType varchar(50) null,
batchId varchar(200),
employerId int(10) null,
foreign key (batchId) references batch(batchId),
foreign key (employerId) references employer(employerId));


 /*create table TrainingPartnerOrganizationDetails */
 create table if not exists TrainingPartnerOrganizationDetails 
(
trainingPartnerRegistrationId int(5) primary key auto_increment ,
applicationId int(5),
organizationName varchar(100),
sPOCName varchar(50),
address varchar(500),
city varchar(30),
state varchar(30),
pincode int(6),
mobileNumber bigint,
alternateMobileNumber bigint,
landlineNumber bigint,
alternateLandlineNumber bigint,
faxNumber bigint,
websites varchar(200),
yearOfEstablishment int(4),
qualificationPacks varchar(200),
qualificationPacksAnnexurePath varchar(200),
nSDCFunded varchar(3),
nSDCFundedCertificatePath varchar(200),
mediumOfInstructions varchar(100),
selfOwnedInstitution int(3),
selfOwnedInstitutionAnnexurePath varchar(200),
franchiseOwnedInstitution int(3),
franchiseOwnedInstitutionAnnexurePath varchar(200),
mobileTrainingInstitution int(3),
mobileTrainingInstitutionAnnexurePath varchar(200) ,
panNumber varchar(10),
panNumberPath varchar(200),
tanNumber varchar(10),
tanNumberPath varchar(200),
turnOverOfInstitution decimal(6,2),
turnOverOfInstitutionBalanceSheetPath varchar(200), 
instituteReceivedAnyGrant varchar(3),
instituteReceivedAnyRecognition varchar(3),
priorExperienceOfInstitutionInSkillDevelopment varchar(3),
anyPriorExperienceOfInstitutionInSkillTraining varchar(3),
trainingStaffDetailsAnnexurePath varchar(200),
foreign key(applicationId) references application(applicationId) 
);

/* create table TrainingPartnerCenterLevelDetails */

create table if not exists TrainingPartnerCenterLevelDetails
(
trainingPartnerCenterId int(5) primary key auto_increment,
trainingPartnerRegistrationId int(5),
nameOfCenter varchar(200),
nameOperationHead varchar(200),
designationOperationHead varchar(200),
emailOperationHead varchar(200),
contactNumberOperationHead bigint,
educationalQualificationOperationHead varchar(200),
experienceOperationHead varchar(200),
cvOperationHeadPath varchar(200),
nameAffiliationCoordinator varchar(200),
designationAffiliationCoordinator varchar(200),
emailAffiliationCoordinator varchar(200),
contactNumberAffiliationCoordinator bigint,
educationalQualificationAffiliationCoordinator varchar(200),
experienceAffiliationCoordinator varchar(200),
cvAffiliationCoordinatorPath varchar(200),
nameSPOC varchar(200),
designationSPOC varchar(200),
emailSPOC varchar(200),
contactNumberSPOC bigint,
educationalQualificationSPOC varchar(200),
experienceSPOC varchar(200),
cvSPOCPath varchar(200),
numberOfPermanentOfficeManager int(3),
numberOftemporaryOfficeManager int(3),
numberOfPermanentOfficeStaff int(3),
numberOfTemporaryOfficeStaff int(3),
numberOfPermanentLabAssistants int(3),
numberOfTemporaryLabAssistants int(3),
numberOfPermanentAccountants int(3),
numberOfTemporaryAccountants int(3),
numberOfPermanentSupportStaff int(3),
numberOfTemporarySupportStaff int(3),
numberOfPermanentOtherEmployees int(3),
numberOfTemporaryOtherEmployees int(3),
areaOfInstitute int(10),
buildingType varchar(20),
sizeOfClassrooms int(10),
classroomPicsPath varchar(200),
numberOfClassrooms int(3),
sizeOfLabs int(10),
labPicsPath varchar(200),
numberOfLabs int(3),
sizeOfWorkshops int(10),
workshopPicsPath varchar(200),
numberOfWorkshops int(3),
mandatoryToolKitpresent varchar(5),
mandatoryToolKitAnnexurePath varchar(200),
mandatoryToolKitPicsPath varchar(200),
safeDrinkingWater varchar(3),
powerBackup varchar(3),
separateToilets varchar(3),
transportFacility varchar(3),
fireSafety varchar (3),
presenceOfLibrary varchar(3),
numberOfTechnicalBooks int(5),
numberOfNonTechnicalBooks int(5),
numberOfMagazines int(5),
numberOfDailies int(5),
remarksOnInfrastructureDetails varchar(1000),
sufficientClassroomIlluminationLevel varchar(3),
sufficientClassroomVentilationLevel varchar(3),
sufficientCenterCleanliness varchar(3),
centerWeatherProtected varchar(3),
remarksOnLearningEnviornment varchar(1000),
printedBrochureOrProspectus varchar(3),
documentedPolicyAndProcedures varchar(3),
concessionPolicy varchar(3),
safeCustodyOfStudentDocuments varchar(3),
studentAgreementWithInstitution varchar(3),
remarksOnStudentAdmissionDetails varchar(1000),
isActive boolean,
foreign key(trainingPartnerRegistrationId) references TrainingPartnerOrganizationDetails(trainingPartnerRegistrationId)
);

/*create table TrainingPartnerInstituteGrant*/

create table if not exists TrainingPartnerInstituteGrant
(
instituteGrantId int(5) primary key auto_increment,
trainingPartnerRegistrationId int(5),
nameOfMinistry varchar(100),
natureOfWork varchar(100),
remarks varchar(1000),
isActive boolean,
foreign key(trainingPartnerRegistrationId) references TrainingPartnerOrganizationDetails(trainingPartnerRegistrationId)
);

/*create table TrainingPartnerInstituteRecognition*/

create table if not exists TrainingPartnerInstituteRecognition
( 
instituteRecognitionId int(5) primary key auto_increment,
trainingPartnerRegistrationId int(5),
nameOfRecognizingBody varchar(200),
recognitionNumber varchar(50),
yearOfRecognition int(4),
validityOfRecognition varchar(50),
isActive boolean,
foreign key(trainingPartnerRegistrationId) references TrainingPartnerOrganizationDetails(trainingPartnerRegistrationId)
);

/*create table TrainingPartnerPriorExperienceInSkillTraining*/

create table if not exists TrainingPartnerPriorExperienceInSkillTraining
(
priorExperienceInSkillTrainingId int(5) primary key auto_increment,
trainingPartnerRegistrationId int(5),
courseName varchar(200),
numberOfBatchesPerYear int(4),
numberOfStudentsInEachBatch int(4),
isActive boolean,
foreign key(trainingPartnerRegistrationId) references TrainingPartnerOrganizationDetails(trainingPartnerRegistrationId)

);

/*create table TrainingPartnerManagementAndStaffAndOfficialsDetails*/
create table if not exists TrainingPartnerManagementAndStaffAndOfficialsDetails
(
managementAndStaffId int(5) primary key auto_increment,
trainingPartnerRegistrationId int(5),
name varchar(100),
designation varchar(50),
emailId varchar(100),
contactNumber bigint,
educationalQualification varchar(100),
experience int(3),
cVPath varchar(200),
isActive boolean,
foreign key(trainingPartnerRegistrationId) references TrainingPartnerOrganizationDetails(trainingPartnerRegistrationId)
);


/*create table TrainingPartnerTrainingStaffDetails*/
create table if not exists TrainingPartnerTrainingStaffDetails
(
trainingStaffId int(5) primary key auto_increment,
trainingPartnerRegistrationId int(5),
name varchar(100),
designation varchar(50),
emailId varchar(100),
educationalQualification varchar(100),
regularOrVisiting varchar(20),
experience int(3),
cVPath varchar(200),
certificatePath varchar(200),
isActive boolean,
foreign key(trainingPartnerRegistrationId) references TrainingPartnerOrganizationDetails(trainingPartnerRegistrationId)
);

/*create table if exists AssessmentBodyRegistrationDetails*/
create table if not exists AssessmentBodyRegistrationDetails (
assessmentBodyRegistrationId int(5) primary key auto_increment,
applicationId int(5),
organizationName varchar(100),
sPOCName varchar(50),
address varchar(500),
city varchar(30),
state varchar(30),
pincode int(6),
mobileNumber bigint,
alternateMobileNumber bigint,
landlineNumber bigint,
alternateLandlineNumber bigint,
faxNumber bigint,
websites varchar(200),
yearOfEstablishment int(4),
priorAssessmentExperience varchar(3),
panNumber varchar(10),
panNumberPath varchar(200),
tanNumber int(10),
tanNumberPath varchar(200),
insituteReceivedAnyRecognition varchar(3),
numberOfTechnicalAssessors int(4),
numberOfNonTechnicalAssessors int(4),
affiliatedToAnySectorSkillCouncil varchar(3),
foreign key(applicationId) references application(applicationId)
);

/*create table AssessmentBodyRecognitions*/
create table if not exists AssessmentBodyRecognitions (
assessmentBodyRecognitionId int(5) primary key auto_increment,
assessmentBodyRegistrationId int(5),
nameOfRecognitionBody varchar(200),
recognitionNumber varchar(50),
yearOfRecognition int(4),
validityOfRecognition varchar(50),
isActive boolean,
foreign key(assessmentBodyRegistrationId) references AssessmentBodyRegistrationDetails(assessmentBodyRegistrationId)
);

/*create table AssessmentsExperienceInTechnicalDomain */

create table if not exists AssessmentsExperienceInTechnicalDomain (
assessmentExperienceId int(5) primary key auto_increment,
assessmentBodyRegistrationId int(5),
domain varchar(50),
numberOfAssessmentsDone	int(5),
isActive boolean,
foreign key(assessmentBodyRegistrationId) references AssessmentBodyRegistrationDetails(assessmentBodyRegistrationId)
);



/*create table AssessmentBodyDirectorsAndManagementTeamDetails */

create table if not exists AssessmentBodyDirectorsAndManagementTeamDetails (
directorsAndManagementId int(5) primary key auto_increment,
assessmentBodyRegistrationId int(5),
name varchar(100),
designation varchar(50),
contactNumber bigint,
emailId varchar(100),
educationalQualification varchar(100),
experience int(3),
cVPath varchar(200),
isActive boolean,
foreign key(assessmentBodyRegistrationId) references AssessmentBodyRegistrationDetails(assessmentBodyRegistrationId)
);


/*create table AssessmentStaffDetails*/

create table if not exists AssessmentStaffDetails(
assessmentStaffId int(5) primary key auto_increment,
assessmentBodyRegistrationId int(5),
name varchar(100),
jobRoleCode varchar(100),
designation varchar(50),
contactNumber bigint,
emailId varchar(100),
state varchar(30),
city varchar(30),
educationalQualification varchar(100),
experience int(3),
cVPath varchar(200),
certificatePath	varchar(200),
isActive boolean,
foreign key(assessmentBodyRegistrationId) references AssessmentBodyRegistrationDetails(assessmentBodyRegistrationId)
);


/*create table AssessmentBodyRegionalOfficeDetails*/
create table if not exists AssessmentBodyRegionalOfficeDetails
(
regionalOfficeId int(5) primary key auto_increment,
assessmentBodyRegistrationId int(5),
address varchar(500),
state varchar(30),
pincode int(6),
contactNumber bigint,
alternateContactNumber bigint,
isActive boolean,
foreign key(assessmentBodyRegistrationId) references AssessmentBodyRegistrationDetails(assessmentBodyRegistrationId)
);

/*create table AssessmentBodyAffiliationDetails*/

create table if not exists AssessmentBodyAffiliationDetails
(
affiliationId int(5) primary key auto_increment,
assessmentBodyRegistrationId int(5),
nameOfSectorSkillCouncil varchar(150),
isActive boolean,
foreign key(assessmentBodyRegistrationId) references AssessmentBodyRegistrationDetails(assessmentBodyRegistrationId)
);