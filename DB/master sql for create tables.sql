
/* create sql for User */

CREATE TABLE if not exists user (
  organizationName varchar(200) NOT NULL,
  sPOCName varchar(200),
 userId varchar(200) unique key not null,
  password varchar(30) not null,
  userRole varchar(20) not null,
  userStatus varchar(15) not NULL,
  Id int(10) primary key AUTO_INCREMENT);
 
 /* create sql for Application */
 
 create table if not exists application(
applicationId int(20) auto_increment Primary key not null,
applicationState varchar(20) not null,
activeFlag boolean,
dateOfSubmission datetime not null,
userId varchar(200) , 
foreign key (userId) references user(userId));

/* create sql for trainingPartnerRegistration */

create table if not exists trainingPartnerRegistration(
	tpId int(15) auto_increment primary key ,
    trainingPartnerName varchar(50) ,
    validityOfRecognition varchar(20),
    priorExposure varchar(20),
    yearOfEstablishment year ,
    priorExposureInSkill varchar(20) ,
    medium varchar(10) ,
    selfOwnedTC boolean ,
    franchiseTC boolean ,
    mobileTC bigint(11) ,
    PAN varchar(10) ,
    TAN varchar(10) ,
    turnover varchar(20),
    nameRecognitionBody varchar(30) ,
    yearOfRecognition year,
    recogintionNumber bigint(20),
    isNSDCfunded varchar(5) ,
    emailDirector varchar(50) ,
    website varchar(50) ,
    addressLine1 varchar(150) ,
    state varchar(20) ,
    PINcode int(6),
    district varchar(30) ,
    city varchar(30) ,
    emailId varchar(50) ,
    mobileNumber bigint(11) ,
    landlineNumber bigint(20) ,
    faxNumber bigint(20),
    firstName varchar(30), 
    middleName varchar(30),
    lastName varchar(30) ,   
     applicationId int(20) not null,
     foreign key (applicationId) references application(applicationId));
	
    /* create sql for tpManagement*/
    
    create table if not exists tpManagement(
tpManagementId int(10) primary key auto_increment,
designation varchar(20),
educationQualification varchar(20) ,
totalEx int(5) ,
addressLine1 varchar(150) ,
state varchar(20) ,
PINcode int(6) ,
district varchar(50) ,
city varchar(50) ,
emailId varchar(50) ,
mobileNumber bigint(20) ,
landlineNumber bigint(30) ,
faxNumber bigint(30) ,
firstName varchar(30),
middleName varchar(30) ,
lastName varchar(30) ,
tpId int(15) not null,
foreign key (tpId) references trainingpartnerregistration(tpId));

/* create sql for assessmentAgencyRegistration*/

create table if not exists assessmentAgencyRegistration(
	abId int(15) auto_increment primary key not null,
    assessmentAgencyName varchar(200) not null,
       applicationId int(20) not null ,
foreign key (applicationId) references application(applicationId));

/* create sql for csvUploaded */

create table if not exists csvUploaded(
csvId int(10) auto_increment Primary key,
csvType varchar(30) not null,
csvName varchar(50) not null,
csvUploadDate date,
csvUploadUserId varchar(200) not null,
foreign key (csvUploadUserId)
 references user(userId));

 /* create sql for businessAudit */

 create table if not exists businessAudit(
auditId int(10) primary key auto_increment,
auditMessage varchar(500) not null,
 userId varchar(200) not null,
 foreign key (userId) references user(userId));

  /* create sql for trainingPartner */

 create table if not exists trainingPartner(
trainingPartnerId varchar(20) primary key,
trainingPartnerName varchar(200) not null,
applicationId int(20) not null,
foreign key (applicationId) references application(applicationId));

/* create sql for documentsUploaded */

create table if not exists documentsUploaded(
documentId int(10) primary key auto_increment,
documentName varchar(200) not null,
documentLocation varchar(150),
applicationId int(20) not null,
foreign key (applicationId) references application(applicationId));

/* create sql for applicationComments */

create table if not exists applicationComments(
commentId int(10) primary key auto_increment,
comment varchar(200) not null,
applicationId int(20) not null,
activeFlag boolean,
foreign key (applicationId) references application(applicationId));

/* create sql for centre */

create table if not exists centre(
centreId int(5) primary key,
centreName varchar(200) not null,
centrePOCContactName varchar(50) not null,
centreAddress varchar(500) not null,
district varchar(50) not null,
state varchar(20) not null,
trainingPartnerId varchar(20) not null,
foreign key (trainingPartnerId) references trainingPartner(trainingPartnerId));

/* create sql for trainer */

create table if not exists trainer(trainerId int(10) primary key,
trainerName varchar(200) not null,
designation varchar(40) not null,
trainingPartnerId varchar(20) not null,
foreign key (trainingPartnerId)
 references trainingPartner(trainingPartnerId ));

 /* create sql for agency */

 create table if not exists agency(
agencyId int(10) primary key,
agencyName varchar(200) not null,
applicationId int(20) not null,
foreign key (applicationId) references application(applicationId));

 /* create sql for assessor */

create table if not exists assessor(
assessorId int(10) primary key,
assessorName varchar(200) not null,
district varchar(50) not null,
 state varchar(30) not null,
agencyId int(10) not null,
foreign key (agencyId)
 references agency(agencyId));

 /* create sql for employer */

 create table if not exists employer(
employerId int(10) primary key,
employerName varchar(200) not null,
locationOfEmployer varchar(500) not null,
locationOfEmployerDistrict varchar(50) not null,
locationOfEmployerState varchar(20));

/* create sql for batch */

create table if not exists batch(
batchId int(10) primary key,
batchName varchar(100) not null,
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

/* create sql for showInterest */

create table if not exists showInterest(
showIntrestId int(10) primary key auto_increment,
batchId int(10),
agencyId int(10),
timeStamp timestamp,
foreign key (batchId) references batch(batchId),
foreign key (agencyId) references agency(agencyId));

/* create sql for batchAssignment */

create table if not exists batchAssignment(
batchAssignmentid int(10) primary key auto_increment,
batchId int(10),
agencyId int(10),
timeStamp timestamp,
responseType varchar(20),
foreign key (batchId) references batch(batchId),
foreign key (agencyId) references agency(agencyId));

/* create sql for certificate */

create table if not exists certificate(
certificateId int(10) primary key auto_increment,
certificateName varchar(50),
certificateUploadDate date,
batchId int(10),
userId varchar(200),
foreign key (batchId) references batch(batchId),
foreign key (userId) references user(userId));

/* create sql for candidate */

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

 