use scgj;

alter table candidate modify column candidateDetailsId varchar(200);
alter table candidate modify column  enrollmentNumber varchar(40);
alter table candidate modify column aadharNumber bigint(12);
alter table candidate modify column mobileNumber bigint(11);
alter table candidate modify column emailId varchar(200);
alter table candidate modify column educationLevel varchar(50);
alter table candidate modify column traineeAddress varchar(500);
alter table candidate modify column traineePinCode int(6);
alter table candidate modify column placementStatus varchar(20);
alter table candidate modify column employmentType varchar(50);
alter table candidate modify column batchId int(10) not null;
alter table candidate add foreign key (batchId) references Batch(batchId);
alter table batch modify column trainingPartnerId varchar(20) not null;
alter table batch add foreign key (trainingPartnerId) references trainingpartner(trainingPartnerId);
alter table batch modify column centreId int(5) not null;
alter table batch add foreign key (centreId) references centre(centreId);