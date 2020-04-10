/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/4/10 11:14:20                           */
/*==============================================================*/


drop table if exists Admin;

drop table if exists CheckInHistory;

drop table if exists ClassLesson;

drop table if exists DictionaryType;

drop table if exists DirectoryData;

drop table if exists Experience;

drop table if exists Menu;

drop table if exists Role;

drop table if exists SignIn;

drop table if exists Task;

drop table if exists TaskMemory;

drop table if exists UserCheck;

drop table if exists UserInfo;

/*==============================================================*/
/* Table: Admin                                                 */
/*==============================================================*/
create table Admin
(
   Id                   int not null,
   Name                 varchar(10),
   Account              varchar(10),
   Password             varchar(20),
   primary key (Id)
);

/*==============================================================*/
/* Table: CheckInHistory                                        */
/*==============================================================*/
create table CheckInHistory
(
   Id                   int not null,
   Start                datetime,
   Over                 datetime,
   CheckInType          varchar(20),
   Number               varchar(10),
   State                int,
   Name                 varchar(20),
   primary key (Id)
);

/*==============================================================*/
/* Table: ClassLesson                                           */
/*==============================================================*/
create table ClassLesson
(
   ClassId              int not null,
   ClassName            varchar(16),
   TeacherName          varchar(16),
   TeacherId            int,
   type                 varchar(16),
   Master               varchar(16),
   People_Count         int,
   Location             varchar(32),
   ClassTime            varchar(16),
   College              varchar(32),
   primary key (ClassId)
);

/*==============================================================*/
/* Table: DictionaryType                                        */
/*==============================================================*/
create table DictionaryType
(
   Id                   int not null auto_increment,
   Sexy                 varchar(20),
   Code                 int(20),
   Description          varchar(20),
   Identity             int(20),
   Creator              int(20),
   CreatorDate          datetime,
   ModificationDate     datetime,
   Modifier             int(20),
   primary key (Id)
);

/*==============================================================*/
/* Table: DirectoryData                                         */
/*==============================================================*/
create table DirectoryData
(
   Id                   int not null auto_increment,
   TypeD                varchar(20),
   KeyD                 varchar(20),
   ValueD               varchar(20),
   DefaultValueD        int(1),
   primary key (Id)
);

/*==============================================================*/
/* Table: Experience                                            */
/*==============================================================*/
create table Experience
(
   StudentId            varchar(10) not null,
   Name                 varchar(10),
   ExperienceValue      integer(10),
   ClassId              int,
   primary key (StudentId)
);

/*==============================================================*/
/* Table: Menu                                                  */
/*==============================================================*/
create table Menu
(
   Id                   integer not null,
   SuperiorMenuNumber   integer(10) not null,
   MenuName             varchar(15) not null,
   ButtonEnglishlogo    varchar(15) not null,
   ButtonChineselogo    varchar(15),
   IsMenu               integer(1),
   Creator              varchar(15),
   CreationDate         datetime,
   ModificationDate     datetime,
   Modifier             varchar(15),
   primary key (Id)
);

/*==============================================================*/
/* Table: Role                                                  */
/*==============================================================*/
create table Role
(
   Id                   int not null,
   Name                 varchar(10),
   MenuId               int,
   primary key (Id)
);

/*==============================================================*/
/* Table: SignIn                                                */
/*==============================================================*/
create table SignIn
(
   Id                   int not null,
   UserId               int not null,
   SignInType           int,
   EndTime              datetime,
   Publisher            varchar(15) not null,
   ClassId              int,
   StartTime            datetime,
   primary key (Id)
);

/*==============================================================*/
/* Table: Task                                                  */
/*==============================================================*/
create table Task
(
   Id                   int not null,
   UserId               int not null,
   Grade                int,
   Answer               varchar(1000),
   GradePoint           varchar(256),
   Task                 varchar(1000),
   ClassId              int,
   Team                 int,
   ScoringMethod        varchar(256),
   LastSubmitTime       datetime,
   primary key (Id)
);

/*==============================================================*/
/* Table: TaskMemory                                            */
/*==============================================================*/
create table TaskMemory
(
   Id                   int not null,
   StudentId            int not null,
   IsParticipate        int,
   Grade                int,
   Anser                varchar(1000),
   GradePoint           varchar(256),
   Task                 varchar(1000),
   ClassId              int,
   Team                 int,
   ScoringMethod        varchar(256),
   LastSubmitTime       datetime,
   primary key (Id)
);

/*==============================================================*/
/* Table: UserCheck                                             */
/*==============================================================*/
create table UserCheck
(
   Id                   int not null,
   Fk_UserInfo_UserCheck_Id int,
   Type                 int,
   ThirdParty           int,
   Identifier           varchar(20),
   PasswordToken        varchar(20),
   CreationDate         datetime,
   Creater              int,
   ModificationDate     datetime,
   Modifier             char(10),
   primary key (Id)
);

/*==============================================================*/
/* Table: UserInfo                                              */
/*==============================================================*/
create table UserInfo
(
   Id                   int not null,
   Number               varchar(10) not null,
   password             varchar(20),
   Name                 varchar(20),
   Image                mediumblob,
   NickName             varchar(20),
   Birthday             datetime,
   Sex                  int,
   School               varchar(20),
   Department           varchar(50),
   Role                 varchar(20),
   Phone                varchar(11),
   Master               varchar(20),
   CreationDate         datetime,
   ModificationDate     datetime,
   Creator              int,
   Modifier             int,
   primary key (Id)
);

alter table CheckInHistory add constraint FK_Reference_3 foreign key (Id)
      references UserInfo (Id) on delete restrict on update restrict;

alter table SignIn add constraint FK_Reference_4 foreign key (UserId)
      references UserInfo (Id) on delete restrict on update restrict;

alter table Task add constraint FK_Reference_5 foreign key (UserId)
      references UserInfo (Id) on delete restrict on update restrict;

alter table TaskMemory add constraint FK_Reference_6 foreign key (StudentId)
      references UserInfo (Id) on delete restrict on update restrict;

alter table UserCheck add constraint FK_Reference_1 foreign key (Fk_UserInfo_UserCheck_Id)
      references UserInfo (Id) on delete restrict on update restrict;

