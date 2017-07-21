
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

/* create table for trainingPartnerRegistration */

create table if not exists trainingPartnerRegistration(
tpId int(15) auto_increment primary key ,
jobRole varchar(100),
totalCenters int(3),
grantsFromGovernment boolean,
recognitionOfInstitute boolean,
priorExperience int(3),	
priorExperienceInSkill int(3),
officeManagerP int(3),
officeManagerT int(3),
officeStaffP int(3),
officeStaffT int(3),
labAttendantsP int(3),
labAttendantsT int(3),
accountantsP int(3),
accountantsT int(3),
supportStaffP int(3),
supportStaffT int(3),
othersP int(3),
othersT int(3),
processOfAdoption  Boolean,
existenceOfFacilitatorsGuide Boolean,
existenceOfTrainerGuide Boolean,
existenceOfParticipantManuals Boolean,
existenceOfAssessmentGuides Boolean,
existenceOfParticipantFeedbackForms  Boolean,
existenceOfTrainingDeliveryPlans Boolean,
reviewProcessForApproval Boolean,
timeTable Boolean,
deliveryPlan Boolean,
monitoringAndEvaluation Boolean,
managementEvaluationRecords Boolean,
labWorkShopExposure Boolean,
industryVisits Boolean,
impartingsOftSkills Boolean,
providingGuidanceOnPlacements Boolean,
placementFacilitation Boolean,
areaOfInstitute varchar(100),
building varchar(200),
sizeOfClassRoom varchar(20),
numberOfClassrooms int(3),
sizeOfLabs int(3),
numberOfLabs int(3),
sizeOfWorkshops varchar(20),
numberOfWorkshops int(3),
presenceOfToolkit boolean,
safeDrinkingWater boolean,
powerBackup boolean,
separateToilet boolean,
transportFacility boolean,
presenceOfLibrary boolean,
technicalBooks  int(3),
nonTechnicalBooks int(3),
magazine int(3),
dailies int(3),
isIlluminationSufficient  Boolean,
isVentilated Boolean,
cleanLiness Boolean ,
weatherProtected Boolean,
printedBrochure Boolean,
documentedPolicy Boolean ,
concessionsPolicy Boolean,
safeCustodyOfDocuments Boolean ,
studentAgreement Boolean,
 yearOfEstablishment year ,
 mediumOfInstructions varchar(10) ,
 mobileNo bigint(11) ,
PAN varchar(10) ,
TAN varchar(10) ,
turnover varchar(20),
yearOfRecognition year,
website varchar(50) ,
    address varchar(500) ,
    state varchar(50) ,
    PINcode int(6),
    district varchar(80) ,
    city varchar(80) ,
       landlineNumber bigint(11) ,
    faxNumber bigint(15),
    nameRecognitionBody varchar(30) ,
recognitionNumber bigint(20),
 validityOfRecognition varchar(20),
 modelOfInstitute varchar(10),
 isNSDCfunded boolean,
applicationId int(20) not null,
trainingPartnerName varchar(200) ,
emailId varchar(200) not null,
foreign key (emailId) references user(userId),
foreign key (trainingPartnerName) references user(organizationName),
    foreign key (applicationId) references application(applicationId));

/* create table for tpManagement */


create table if not exists tpManagement(
tpManagementId int(10) primary key auto_increment,
name  varchar(200),
designation varchar(200),
contactNumber bigint(11),
educationalQualification varchar(200), 
experience int(3),
emailId varchar(200),
tpId int(15),
foreign key (tpId) references trainingpartnerregistration(tpId));

/* create table for assessmentAgencyRegistration */

create table if not exists assessmentAgencyRegistration(
	abId int(15) auto_increment primary key not null,
address varchar(500), 
state varchar(50),
website varchar(50),
mobileNumber bigInt(11),
landlineNo  bigint(11), 
PINcode int(6),
faxNumber bigint(15),
yearofEstablishment year,
modelofInstitution varchar(10),
PAN varchar(10),
TAN varchar(10),
turnover varchar(20),
recognitionWithAnyGovt boolean,
nameRecognizingBody varchar(500),
recognitionNumber varchar(10),
yearOfRecognition year,
validityOfRecognition date,
affiliatedWithAnySSC  Boolean,
assessmentExperience boolean,
years int(3),
totalNumberOfAssessmentComplete int(3),
applicationId int(20) not null ,
assessmentAgencyName varchar(200),
foreign key (assessmentAgencyName) references user(organizationName),
foreign key (applicationId) references application(applicationId));

/* create table for abManagement */

create table if not exists abManagement(
abManagementId int(10) primary key auto_increment,
name varchar(500),
designation varchar(200),
ContactNumber bigInt,
EducationalQualification varchar(200),
Experience int(3),
emailId varchar(200),
Office varchar(200),
address varchar(500),
state varchar(50),
PINcode int(6),
landlineNo bigInt(11),
abId int(15) not null,
foreign key (abId) references assessmentAgencyRegistration(abId));

/* create table for abAssessor */

create table if not exists abAssessor(
abassessorId int(10) Primary key auto_increment,
name varchar(500),
jobRole varchar(100),
designation varchar(200),
district varchar(50),
state varchar(50),
educationalQualification varchar(200),
experience int(3),
emailId varchar(200),
contactNo bigInt(11),
abId int(15) not null,
foreign key (abId) References assessmentagencyregistration(abId));

/* create table for tpTrainer */

create table if not exists tpTrainer(
teachingStaffrelevantQP Boolean,
name varchar(500),
designation varchar(200),
educationalQualification varchar(200),
experience int(3),
emailId varchar(200),
regularVisiting varchar(10),
abId int(15) not null,
foreign key (abId) references assessmentAgencyRegistration(abId));

/* create table for csvUploaded */

create table if not exists csvUploaded(
csvId int(10) auto_increment Primary key,
csvType varchar(30) not null,
csvName varchar(50) not null,
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
batchId int(10) primary key,
batchName varchar(200) not null,
batchType varchar(10) not null,
trainingPartnerId varchar(20),
centreId int(5),
trainerId int(10),
totalCandidatesInBatch int(5) not null,
batchStartDate date not null,
batchEndDate date not null,
jobRole varchar(100) not null,
jobRoleCode varchar(30) not null,
maximumMarksTheory decimal(5,2),
maximumMarksPractical decimal(5,2),
level int(5) not null,
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
batchId int(10),
agencyId int(10),
timeStamp timestamp,
foreign key (batchId) references batch(batchId),
foreign key (agencyId) references agency(agencyId));

/* create table for batchAssignment */

create table if not exists batchAssignment(
batchAssignmentid int(10) primary key auto_increment,
batchId int(10),
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
batchId int(10),
userId varchar(200),
foreign key (batchId) references batch(batchId),
foreign key (userId) references user(userId));

/* create table for candidate */

create table if not exists candidate(
candidateDetailsId int(10) primary key,
candidateName varchar(200) not null,
enrollmentNumber varchar(40) not null,
gender varchar(6) not null,
dateOfBirth date not null,
nameOfFatherOrHusband varchar(200) not null,
aadharNumber bigint(12) not null,
mobileNumber bigint(11) not null,
emailId varchar(200) not null,
educationLevel varchar(50) not null,
traineeAddress varchar(500) not null,
traineePinCode int(6) not null,
marksObtainedTheory decimal(5,2),
marksObtainedPractical decimal(5,2),
result varchar(5),
certified varchar(5),
placementStatus varchar(20) not null,
dateOfJoining date,
employmentType varchar(50) not null,
batchId int(10),
employerId int(10),
foreign key (batchId) references batch(batchId),
foreign key (employerId) references employer(employerId));


  			