(ns garde-manger.test-data)

(def sample-jira-issues `([{"expand" "operations,editmeta,changelog,transitions,renderedFields",
   "id" "46551",
   "self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/46551",
   "key" "ISCA-17644",
   "fields"
   {"customfield_10141" nil,
    "customfield_10184" nil,
    "customfield_10193" nil,
    "customfield_11436" nil,
    "created" "2011-06-21T12:44:19.000-0400",
    "customfield_10148" nil,
    "reporter"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=church",
     "name" "church",
     "key" "church",
     "emailAddress" "church@ncbi.nlm.nih.gov",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Church, Deanna",
     "active" true,
     "timeZone" "America/New_York"},
    "customfield_10187" nil,
    "progress" {"progress" 0, "total" 0},
    "aggregatetimespent" nil,
    "aggregateprogress" {"progress" 0, "total" 0},
    "customfield_10230" nil,
    "priority"
    {"self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/priority/4",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/priorities/minor.png",
     "name" "Normal",
     "id" "4"},
    "customfield_10166"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10178",
     "value" "0",
     "id" "10178"},
    "customfield_10169" nil,
    "versions" [],
    "customfield_10126" nil,
    "customfield_10195" 7.813331E7,
    "aggregatetimeestimate" nil,
    "customfield_10334" nil,
    "customfield_10333" nil,
    "customfield_10167" nil,
    "timeestimate" nil,
    "customfield_10198"
    "Mutations and deletions (whole gene and exon-level) affecting both copies of WWOX are associated with autosomal recessive early infantile epileptic encephalopathy and autosomal recessive spinocerebellar ataxia 12. See Mignot et al., 2015 (PMID  25411445) for a discussion of genotype-phenotype associations in these recessive disorders.",
    "customfield_10147" "https://omim.org/entry/605131",
    "resolutiondate" "2017-11-08T14:04:12.000-0500",
    "customfield_11635" 0.0,
    "customfield_10160" "chr16:78133310-79246564",
    "customfield_11430" "0|i0bctz:",
    "fixVersions" [],
    "customfield_10030" "WWOX",
    "customfield_10191" nil,
    "customfield_11435" nil,
    "project"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/project/10160",
     "id" "10160",
     "key" "ISCA",
     "name" "ISCA",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?pid=10160&avatarId=10020",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=small&pid=10160&avatarId=10020",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=xsmall&pid=10160&avatarId=10020",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=medium&pid=10160&avatarId=10020"}},
    "customfield_10189" nil,
    "customfield_11332" "17470496; 24369382",
    "timeoriginalestimate" nil,
    "customfield_10194" nil,
    "lastViewed" "2017-11-13T11:03:09.662-0500",
    "customfield_10190" nil,
    "customfield_10534" "+",
    "customfield_10180" "2013-05-09 19:20:09.693",
    "customfield_10201" nil,
    "customfield_10152" nil,
    "summary" "Initial load of genes from NCBI annotation run 37.2",
    "creator"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=church",
     "name" "church",
     "key" "church",
     "emailAddress" "church@ncbi.nlm.nih.gov",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Church, Deanna",
     "active" true,
     "timeZone" "America/New_York"},
    "customfield_10181"
    "1_*:*_1_*:*_162611898606_*|*_6_*:*_1_*:*_0_*|*_10024_*:*_1_*:*_38878723103_*|*_10023_*:*_1_*:*_2571787",
    "labels" ["DBDAR" "EIEE" "LitReview"],
    "customfield_10335" nil,
    "timespent" nil,
    "workratio" -1,
    "customfield_10536" "Jan 2017 interim GRCh38.p10",
    "customfield_10161" nil,
    "status"
    {"self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/status/6",
     "description"
     "The issue is considered finished, the resolution is correct. Issues which are closed can be reopened.",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/statuses/closed.png",
     "name" "Closed",
     "id" "6",
     "statusCategory"
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/statuscategory/3",
      "id" 3,
      "key" "done",
      "colorName" "green",
      "name" "Done"}},
    "subtasks" [],
    "customfield_11630" nil,
    "customfield_10144" nil,
    "customfield_10196" nil,
    "customfield_10164"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10170",
     "value" "no",
     "id" "10170"},
    "customfield_10535" 7.8099413E7,
    "customfield_10192" nil,
    "customfield_11331"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10622",
     "value" "AR",
     "id" "10622"},
    "customfield_10185" nil,
    "customfield_10149"
    ">too many PMIDs for Jira; see Gene page for info",
    "customfield_11431" nil,
    "customfield_10188" nil,
    "customfield_10532" "chr16:78099413-79212667",
    "watches"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/ISCA-17644/watchers",
     "watchCount" 3,
     "isWatching" false},
    "assignee"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=john.herriges%40aruplab.com",
     "name" "john.herriges@aruplab.com",
     "key" "john.herriges@aruplab.com",
     "emailAddress" "jherriges@cmh.edu",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "John Herriges",
     "active" true,
     "timeZone" "America/New_York"},
    "environment" nil,
    "votes"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/ISCA-17644/votes",
     "votes" 0,
     "hasVoted" false},
    "customfield_11437" nil,
    "customfield_11631" nil,
    "duedate" nil,
    "issuelinks" [],
    "customfield_10157" "https://www.ncbi.nlm.nih.gov/gene/51741",
    "updated" "2017-11-08T14:04:12.000-0500",
    "customfield_10533" "+",
    "customfield_10332" nil,
    "components"
    [{"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/component/10295",
      "id" "10295",
      "name" "chr16"}],
    "customfield_10156"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10171",
     "value" "protein-coding",
     "id" "10171"},
    "customfield_10200" nil,
    "customfield_10150" nil,
    "customfield_10145" "16q23.1-q23.2",
    "customfield_10158" "NC_000016.9",
    "customfield_10538" nil,
    "customfield_10531" nil,
    "customfield_10183" nil,
    "customfield_10168" nil,
    "customfield_11632" nil,
    "customfield_10199"
    "Whole gene duplication of WWOX is not currently known to be associated with developmental phenotypes.",
    "customfield_10143" nil,
    "customfield_10197" nil,
    "issuetype"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issuetype/31",
     "id" "31",
     "description" "Gene curation for ISCA group",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/issuetypes/genericissue.png",
     "name" "ISCA Gene Curation",
     "subtask" false},
    "customfield_10186" nil,
    "customfield_11633" nil,
    "customfield_10146" nil,
    "customfield_10165"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10214",
     "value" "30: Gene associated with autosomal recessive phenotype",
     "id" "10214"},
    "customfield_11330"
    "Spinocerebellar ataxia, autosomal recessive 12",
    "description"
    "ISCA Gene Curation\nSYMBOL: WWOX\nALIASES: D16S432E, EIEE28, FOR, FRA16D, HHCMA56, PRO0128, SCAR12, SDR41C1, WOX1\n",
    "customfield_11730"
    [{"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=erica.f.andersen%40aruplab.com",
      "name" "erica.f.andersen@aruplab.com",
      "key" "erica.f.andersen@aruplab.com",
      "emailAddress" "erica.f.andersen@aruplab.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Erica Andersen",
      "active" true,
      "timeZone" "America/Denver"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=erin.baldwin%40aruplab.com",
      "name" "erin.baldwin@aruplab.com",
      "key" "erin.baldwin@aruplab.com",
      "emailAddress" "erin.baldwin@aruplab.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Erin Baldwin",
      "active" true,
      "timeZone" "America/New_York"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=john.herriges%40aruplab.com",
      "name" "john.herriges@aruplab.com",
      "key" "john.herriges@aruplab.com",
      "emailAddress" "jherriges@cmh.edu",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "John Herriges",
      "active" true,
      "timeZone" "America/New_York"}],
    "customfield_10537" "NC_000016.10",
    "resolution"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/resolution/16",
     "id" "16",
     "description" "Work on the issue is complete.",
     "name" "Complete"},
    "customfield_10331" nil,
    "aggregatetimeoriginalestimate" nil}}
  {"expand" "operations,editmeta,changelog,transitions,renderedFields",
   "id" "162909",
   "self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/162909",
   "key" "ISCA-37489",
   "fields"
   {"customfield_10141" nil,
    "customfield_10184"
    "The paper by Shoubridge describes missense mutations in males with intellectual disability. \"In addition to moderate to severe intellectual disability in all affected males, seizures, autistic traits, psychiatric problems and delayed early language skills were noted, although none of these additional phenotypes were consistent in all affected individuals in the families.\" The authors showed the mutations reduced the expression of the protein.",
    "customfield_10193" nil,
    "customfield_11436" nil,
    "created" "2015-04-06T10:24:58.000-0400",
    "customfield_10148" nil,
    "reporter"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=burnsir%40labcorp.com",
     "name" "burnsir@labcorp.com",
     "key" "burnsir@labcorp.com",
     "emailAddress" "Burnsir@LabCorp.com",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Burnside, Rachel",
     "active" true,
     "timeZone" "America/New_York"},
    "customfield_10187" "23674175",
    "progress" {"progress" 0, "total" 0},
    "aggregatetimespent" nil,
    "aggregateprogress" {"progress" 0, "total" 0},
    "customfield_10230" nil,
    "priority"
    {"self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/priority/4",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/priorities/minor.png",
     "name" "Normal",
     "id" "4"},
    "customfield_10166"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10178",
     "value" "0",
     "id" "10178"},
    "customfield_10169"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10192",
     "value" "Loss of function score",
     "id" "10192"},
    "versions" [],
    "customfield_10126" nil,
    "customfield_10195" nil,
    "aggregatetimeestimate" nil,
    "customfield_10334" nil,
    "customfield_10333" nil,
    "customfield_10167" nil,
    "timeestimate" nil,
    "customfield_10198" nil,
    "customfield_10147" nil,
    "resolutiondate" "2017-09-11T15:51:30.000-0400",
    "customfield_11635" nil,
    "customfield_10160" "chrX:53262058-53350522",
    "customfield_11430" "0|i0kdmv:",
    "fixVersions" [],
    "customfield_10030" "IQSEC2",
    "customfield_10191" nil,
    "customfield_11435" nil,
    "project"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/project/10160",
     "id" "10160",
     "key" "ISCA",
     "name" "ISCA",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?pid=10160&avatarId=10020",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=small&pid=10160&avatarId=10020",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=xsmall&pid=10160&avatarId=10020",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=medium&pid=10160&avatarId=10020"}},
    "customfield_10189" nil,
    "customfield_11332" nil,
    "timeoriginalestimate" nil,
    "customfield_10194" nil,
    "lastViewed" nil,
    "customfield_10190" nil,
    "customfield_10534" nil,
    "customfield_10180" "2015-09-28 11:44:04.983",
    "customfield_10201" nil,
    "customfield_10152"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10190",
     "value" "Target: Increase probe density",
     "id" "10190"},
    "summary" "syndromic intellectual disability",
    "creator"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=burnsir%40labcorp.com",
     "name" "burnsir@labcorp.com",
     "key" "burnsir@labcorp.com",
     "emailAddress" "Burnsir@LabCorp.com",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Burnside, Rachel",
     "active" true,
     "timeZone" "America/New_York"},
    "customfield_10181"
    "1_*:*_1_*:*_65920787687_*|*_4_*:*_1_*:*_9434839790_*|*_6_*:*_2_*:*_1473553890_*|*_10024_*:*_1_*:*_4910_*|*_10023_*:*_1_*:*_5720",
    "labels" ["DBDTier1" "LitReview"],
    "customfield_10335"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10251",
     "value" "No",
     "id" "10251"},
    "timespent" nil,
    "workratio" -1,
    "customfield_10536" nil,
    "customfield_10161" nil,
    "status"
    {"self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/status/6",
     "description"
     "The issue is considered finished, the resolution is correct. Issues which are closed can be reopened.",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/statuses/closed.png",
     "name" "Closed",
     "id" "6",
     "statusCategory"
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/statuscategory/3",
      "id" 3,
      "key" "done",
      "colorName" "green",
      "name" "Done"}},
    "subtasks" [],
    "customfield_11630" nil,
    "customfield_10144" nil,
    "customfield_10196"
    "While most reported mutations are sequence level, at least two intragenic duplications have been reported.",
    "customfield_10164" nil,
    "customfield_10535" nil,
    "customfield_10192" nil,
    "customfield_11331" nil,
    "customfield_10185" "21479374 ",
    "customfield_10149" "24306141, 20473311, 21479374, 23674175",
    "customfield_11431" nil,
    "customfield_10188"
    "The article by Mau-Them et al describes two de novo intragenic duplications and a nonsense mutation in males with severe syndromic ID characterised by \"progressive postnatal microcephaly, absence of speech and midline stereotypic hand movements similar to those observed in Rett or variant Rett syndromes.\" This article also cites the Gandomi reference describing two males with similar features who both have de novo truncating mutations.",
    "customfield_10532" nil,
    "watches"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/ISCA-37489/watchers",
     "watchCount" 5,
     "isWatching" false},
    "assignee" nil,
    "environment" nil,
    "votes"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/ISCA-37489/votes",
     "votes" 0,
     "hasVoted" false},
    "customfield_11437" nil,
    "customfield_11631" nil,
    "duedate" nil,
    "issuelinks" [],
    "customfield_10157" "https://www.ncbi.nlm.nih.gov/gene/23096",
    "updated" "2017-11-01T09:40:05.000-0400",
    "customfield_10533" nil,
    "customfield_10332" nil,
    "components"
    [{"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/component/10302",
      "id" "10302",
      "name" "chrX"}],
    "customfield_10156" nil,
    "customfield_10200" nil,
    "customfield_10150" nil,
    "customfield_10145" "Xp11.22",
    "customfield_10158" "NC_000023.10",
    "customfield_10538" nil,
    "customfield_10531" nil,
    "customfield_10183" "20473311",
    "customfield_10168" nil,
    "customfield_11632" nil,
    "customfield_10199" nil,
    "customfield_10143" nil,
    "customfield_10197" nil,
    "issuetype"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issuetype/31",
     "id" "31",
     "description" "Gene curation for ISCA group",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/issuetypes/genericissue.png",
     "name" "ISCA Gene Curation",
     "subtask" false},
    "customfield_10186"
    "Morleo et al describe a female patient with a t(X;20) with a severe phenotype that included intellectual disability, infantile seizures, and developmental delay. The authors used BAC FISH to map the breakpoints and found the translocation disrupted IQSEC2, between exons 1 and 2 of the longest transcript, which may also disrupt 5' regulatory sequences for the shorter trasncripts.",
    "customfield_11633" nil,
    "customfield_10146" nil,
    "customfield_10165"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10185",
     "value" "3",
     "id" "10185"},
    "customfield_11330" nil,
    "description"
    "This gene encodes a guanine nucleotide exchange factor for the ARF family of small GTP-binding proteins. The encoded protein is a component of the postsynaptic density at excitatory synapses, and may play a critical role in cytoskeletal and synaptic organization through the activation of selected ARF substrates including ARF1 and ARF6. Mutations in this gene have been implicated in nonsyndromic X-linked mental retardation. Alternatively spliced transcript variants encoding multiple isoforms have been observed for this gene. [provided by RefSeq, Aug 2011]",
    "customfield_11730"
    [{"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=burnsir%40labcorp.com",
      "name" "burnsir@labcorp.com",
      "key" "burnsir@labcorp.com",
      "emailAddress" "Burnsir@LabCorp.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Burnside, Rachel",
      "active" true,
      "timeZone" "America/New_York"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=chenc8",
      "name" "chenc8",
      "key" "chenc8",
      "emailAddress" "chao.chen@nih.gov",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Chen, Chao",
      "active" true,
      "timeZone" "America/New_York"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=erica.f.andersen%40aruplab.com",
      "name" "erica.f.andersen@aruplab.com",
      "key" "erica.f.andersen@aruplab.com",
      "emailAddress" "erica.f.andersen@aruplab.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Erica Andersen",
      "active" true,
      "timeZone" "America/Denver"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=eriggs%40geisinger.edu",
      "name" "eriggs@geisinger.edu",
      "key" "erin.riggs@emory.edu",
      "emailAddress" "eriggs@geisinger.edu",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Erin Riggs",
      "active" true,
      "timeZone" "America/Chicago"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=thefferon",
      "name" "thefferon",
      "key" "thefferon",
      "emailAddress" "timothy.hefferon@nih.gov",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10165",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10165",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10165",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10165"},
      "displayName" "Tim Hefferon",
      "active" false,
      "timeZone" "America/New_York"}],
    "customfield_10537" nil,
    "resolution"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/resolution/16",
     "id" "16",
     "description" "Work on the issue is complete.",
     "name" "Complete"},
    "customfield_10331" nil,
    "aggregatetimeoriginalestimate" nil}}
  {"expand" "operations,editmeta,changelog,transitions,renderedFields",
   "id" "65678",
   "self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/65678",
   "key" "ISCA-36770",
   "fields"
   {"customfield_10141" nil,
    "customfield_10184" nil,
    "customfield_10193" nil,
    "customfield_11436" nil,
    "created" "2011-06-21T16:14:01.000-0400",
    "customfield_10148" nil,
    "reporter"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=church",
     "name" "church",
     "key" "church",
     "emailAddress" "church@ncbi.nlm.nih.gov",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Church, Deanna",
     "active" true,
     "timeZone" "America/New_York"},
    "customfield_10187" nil,
    "progress" {"progress" 0, "total" 0},
    "aggregatetimespent" nil,
    "aggregateprogress" {"progress" 0, "total" 0},
    "customfield_10230" nil,
    "priority"
    {"self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/priority/4",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/priorities/minor.png",
     "name" "Normal",
     "id" "4"},
    "customfield_10166"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10178",
     "value" "0",
     "id" "10178"},
    "customfield_10169"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10192",
     "value" "Loss of function score",
     "id" "10192"},
    "versions" [],
    "customfield_10126" nil,
    "customfield_10195" 1.55250824E8,
    "aggregatetimeestimate" nil,
    "customfield_10334" nil,
    "customfield_10333" nil,
    "customfield_10167" nil,
    "timeestimate" nil,
    "customfield_10198"
    "PMID 9450876 and 21416596 report an association between deletions encompassing EN2 and clinical features of 7q terminal deletion syndrome, however focal deletions of EN2 have not yet been reported in clinical populations.",
    "customfield_10147" "https://omim.org/entry/131310",
    "resolutiondate" "2012-08-26T17:21:26.000-0400",
    "customfield_11635" 0.433,
    "customfield_10160" "chr7:155250824-155257526",
    "customfield_11430" "0|i0k613:",
    "fixVersions" [],
    "customfield_10030" "EN2",
    "customfield_10191" nil,
    "customfield_11435" nil,
    "project"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/project/10160",
     "id" "10160",
     "key" "ISCA",
     "name" "ISCA",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?pid=10160&avatarId=10020",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=small&pid=10160&avatarId=10020",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=xsmall&pid=10160&avatarId=10020",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=medium&pid=10160&avatarId=10020"}},
    "customfield_10189" nil,
    "customfield_11332" nil,
    "timeoriginalestimate" nil,
    "customfield_10194" nil,
    "lastViewed" "2017-11-13T11:07:30.314-0500",
    "customfield_10190" nil,
    "customfield_10534" "+",
    "customfield_10180" "2011-11-21 14:56:24.607",
    "customfield_10201" nil,
    "customfield_10152"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10191",
     "value" "Do not target",
     "id" "10191"},
    "summary" "Initial load of genes from NCBI annotation run 37.2",
    "creator"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=church",
     "name" "church",
     "key" "church",
     "emailAddress" "church@ncbi.nlm.nih.gov",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Church, Deanna",
     "active" true,
     "timeZone" "America/New_York"},
    "customfield_10181"
    "1_*:*_1_*:*_28490333146_*|*_10023_*:*_1_*:*_9584_*|*_6_*:*_1_*:*_0_*|*_10024_*:*_1_*:*_8838503203",
    "labels" ["LitReview"],
    "customfield_10335" nil,
    "timespent" nil,
    "workratio" -1,
    "customfield_10536" "Jan 2017 interim GRCh38.p10",
    "customfield_10161" nil,
    "status"
    {"self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/status/6",
     "description"
     "The issue is considered finished, the resolution is correct. Issues which are closed can be reopened.",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/statuses/closed.png",
     "name" "Closed",
     "id" "6",
     "statusCategory"
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/statuscategory/3",
      "id" 3,
      "key" "done",
      "colorName" "green",
      "name" "Done"}},
    "subtasks" [],
    "customfield_11630" nil,
    "customfield_10144" nil,
    "customfield_10196"
    "Certain SNPs in the EN2 gene have been reported in association with Autism Spectrum Disorder (MIM# 611016).",
    "customfield_10164"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10169",
     "value" "yes",
     "id" "10169"},
    "customfield_10535" 1.55458129E8,
    "customfield_10192" nil,
    "customfield_11331" nil,
    "customfield_10185" nil,
    "customfield_10149"
    ">too many PMIDs for Jira; see Gene page for info",
    "customfield_11431" nil,
    "customfield_10188" nil,
    "customfield_10532" "chr7:155458129-155464831",
    "watches"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/ISCA-36770/watchers",
     "watchCount" 4,
     "isWatching" false},
    "assignee" nil,
    "environment" nil,
    "votes"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/ISCA-36770/votes",
     "votes" 0,
     "hasVoted" false},
    "customfield_11437" nil,
    "customfield_11631" nil,
    "duedate" nil,
    "issuelinks" [],
    "customfield_10157" "https://www.ncbi.nlm.nih.gov/gene/2020",
    "updated" "2017-10-27T14:36:35.000-0400",
    "customfield_10533" "+",
    "customfield_10332" nil,
    "components"
    [{"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/component/10286",
      "id" "10286",
      "name" "chr7"}],
    "customfield_10156"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10171",
     "value" "protein-coding",
     "id" "10171"},
    "customfield_10200" nil,
    "customfield_10150" nil,
    "customfield_10145" "7q36.3",
    "customfield_10158" "NC_000007.13",
    "customfield_10538" nil,
    "customfield_10531" nil,
    "customfield_10183" nil,
    "customfield_10168" nil,
    "customfield_11632" nil,
    "customfield_10199" nil,
    "customfield_10143" nil,
    "customfield_10197" nil,
    "issuetype"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issuetype/31",
     "id" "31",
     "description" "Gene curation for ISCA group",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/issuetypes/genericissue.png",
     "name" "ISCA Gene Curation",
     "subtask" false},
    "customfield_10186" nil,
    "customfield_11633" nil,
    "customfield_10146" nil,
    "customfield_10165"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10182",
     "value" "0",
     "id" "10182"},
    "customfield_11330" nil,
    "description" "ISCA Gene Curation\nSYMBOL: EN2\nALIASES:  \n",
    "customfield_11730"
    [{"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=erin.baldwin%40aruplab.com",
      "name" "erin.baldwin@aruplab.com",
      "key" "erin.baldwin@aruplab.com",
      "emailAddress" "erin.baldwin@aruplab.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Erin Baldwin",
      "active" true,
      "timeZone" "America/New_York"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=eriggs%40geisinger.edu",
      "name" "eriggs@geisinger.edu",
      "key" "erin.riggs@emory.edu",
      "emailAddress" "eriggs@geisinger.edu",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Erin Riggs",
      "active" true,
      "timeZone" "America/Chicago"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=gli%40genedx.com",
      "name" "gli@genedx.com",
      "key" "gli@genedx.com",
      "emailAddress" "gli@genedx.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10160",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10160",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10160",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10160"},
      "displayName" "Guang Li",
      "active" true,
      "timeZone" "America/New_York"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=trent.burgess%40vcgs.org.au",
      "name" "trent.burgess@vcgs.org.au",
      "key" "trent.burgess@vcgs.org.au",
      "emailAddress" "trent.burgess@vcgs.org.au",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Trent Burgess",
      "active" true,
      "timeZone" "America/New_York"}],
    "customfield_10537" "NC_000007.14",
    "resolution"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/resolution/16",
     "id" "16",
     "description" "Work on the issue is complete.",
     "name" "Complete"},
    "customfield_10331" nil,
    "aggregatetimeoriginalestimate" nil}}
  {"expand" "operations,editmeta,changelog,transitions,renderedFields",
   "id" "56262",
   "self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/56262",
   "key" "ISCA-27354",
   "fields"
   {"customfield_10141" nil,
    "customfield_10184" nil,
    "customfield_10193" nil,
    "customfield_11436" nil,
    "created" "2011-06-21T14:26:55.000-0400",
    "customfield_10148" nil,
    "reporter"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=church",
     "name" "church",
     "key" "church",
     "emailAddress" "church@ncbi.nlm.nih.gov",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Church, Deanna",
     "active" true,
     "timeZone" "America/New_York"},
    "customfield_10187" nil,
    "progress" {"progress" 0, "total" 0},
    "aggregatetimespent" nil,
    "aggregateprogress" {"progress" 0, "total" 0},
    "customfield_10230" nil,
    "priority"
    {"self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/priority/4",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/priorities/minor.png",
     "name" "Normal",
     "id" "4"},
    "customfield_10166"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10178",
     "value" "0",
     "id" "10178"},
    "customfield_10169" nil,
    "versions" [],
    "customfield_10126" nil,
    "customfield_10195" 8.0850978E7,
    "aggregatetimeestimate" nil,
    "customfield_10334" nil,
    "customfield_10333" nil,
    "customfield_10167" nil,
    "timeestimate" nil,
    "customfield_10198"
    "PMID 27588452: Namburi P, (2016): Bi-allelic Truncating Mutations in CEP78, Encoding Centrosomal Protein 78, Cause Cone-Rod Degeneration with Sensorineural Hearing Loss\r\n\r\nPMID 27627988: Fu Q (2017): WES and WGS testing of patients from two independent families with juvenile/adult-onset cone-rod dystrophy and sensorineural hearing loss identified two homozygous rare variants that affect splicing of CEP78.\r\n\r\nPMID 27588451: Nikopoulos K (2016): Exome analysis of a cohort of individuals with cone-rod degeneration (CRD) identified biallelic mutations in CEP78 in three patients from two families: one from Greece and another from Sweden. The Greek patient was homozygous for the c.499+1G>T (IVS3+1G>T) mutation. The Swedish patients were compound heterozygotes for c.499+5G>A (IVS3+5G>A) and c.633delC (p.Trp212Glyfs(∗)18). In addition to CRD, these individuals had hearing deficits.",
    "customfield_10147" nil,
    "resolutiondate" "2017-10-23T15:35:04.000-0400",
    "customfield_11635" 0.0,
    "customfield_10160" "chr9:80850978-80886799",
    "customfield_11430" "0|i0ftv3:",
    "fixVersions" [],
    "customfield_10030" "CEP78",
    "customfield_10191" nil,
    "customfield_11435" nil,
    "project"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/project/10160",
     "id" "10160",
     "key" "ISCA",
     "name" "ISCA",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?pid=10160&avatarId=10020",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=small&pid=10160&avatarId=10020",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=xsmall&pid=10160&avatarId=10020",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=medium&pid=10160&avatarId=10020"}},
    "customfield_10189" nil,
    "customfield_11332" nil,
    "timeoriginalestimate" nil,
    "customfield_10194" nil,
    "lastViewed" "2017-10-24T15:52:36.105-0400",
    "customfield_10190" nil,
    "customfield_10534" "+",
    "customfield_10180" "2017-10-11 17:01:46.547",
    "customfield_10201" nil,
    "customfield_10152"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10187",
     "value" "N/A- Autosomal recessive",
     "id" "10187"},
    "summary" "Initial load of genes from NCBI annotation run 37.2",
    "creator"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=church",
     "name" "church",
     "key" "church",
     "emailAddress" "church@ncbi.nlm.nih.gov",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Church, Deanna",
     "active" true,
     "timeZone" "America/New_York"},
    "customfield_10181"
    "1_*:*_1_*:*_199747581410_*|*_6_*:*_1_*:*_0_*|*_10023_*:*_1_*:*_21076_*|*_10025_*:*_1_*:*_358887064",
    "labels" ["ClinGenCurated"],
    "customfield_10335" nil,
    "timespent" nil,
    "workratio" -1,
    "customfield_10536" "Jan 2017 interim GRCh38.p10",
    "customfield_10161" nil,
    "status"
    {"self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/status/6",
     "description"
     "The issue is considered finished, the resolution is correct. Issues which are closed can be reopened.",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/statuses/closed.png",
     "name" "Closed",
     "id" "6",
     "statusCategory"
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/statuscategory/3",
      "id" 3,
      "key" "done",
      "colorName" "green",
      "name" "Done"}},
    "subtasks" [],
    "customfield_11630" nil,
    "customfield_10144" nil,
    "customfield_10196" nil,
    "customfield_10164"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10170",
     "value" "no",
     "id" "10170"},
    "customfield_10535" 7.8236062E7,
    "customfield_10192" nil,
    "customfield_11331" nil,
    "customfield_10185" nil,
    "customfield_10149"
    "7790358:11076968:12221128:12477932:12852856:14654843:14702039:16344560:16462731:20562859",
    "customfield_11431" nil,
    "customfield_10188" nil,
    "customfield_10532" "chr9:78236062-78278431",
    "watches"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/ISCA-27354/watchers",
     "watchCount" 3,
     "isWatching" false},
    "assignee"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=tbrandt%40genedx.com",
     "name" "tbrandt@genedx.com",
     "key" "tbrandt@genedx.com",
     "emailAddress" "tbrandt@genedx.com",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Tracy Brandt",
     "active" true,
     "timeZone" "America/New_York"},
    "environment" nil,
    "votes"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/ISCA-27354/votes",
     "votes" 0,
     "hasVoted" false},
    "customfield_11437" nil,
    "customfield_11631" nil,
    "duedate" nil,
    "issuelinks" [],
    "customfield_10157" "https://www.ncbi.nlm.nih.gov/gene/84131",
    "updated" "2017-10-23T15:35:04.000-0400",
    "customfield_10533" "+",
    "customfield_10332" nil,
    "components"
    [{"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/component/10288",
      "id" "10288",
      "name" "chr9"}],
    "customfield_10156"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10171",
     "value" "protein-coding",
     "id" "10171"},
    "customfield_10200" nil,
    "customfield_10150" nil,
    "customfield_10145" "9q21.2",
    "customfield_10158" "NC_000009.11",
    "customfield_10538" nil,
    "customfield_10531" nil,
    "customfield_10183" nil,
    "customfield_10168" nil,
    "customfield_11632" nil,
    "customfield_10199" nil,
    "customfield_10143" nil,
    "customfield_10197" nil,
    "issuetype"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issuetype/31",
     "id" "31",
     "description" "Gene curation for ISCA group",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/issuetypes/genericissue.png",
     "name" "ISCA Gene Curation",
     "subtask" false},
    "customfield_10186" nil,
    "customfield_11633" nil,
    "customfield_10146" nil,
    "customfield_10165"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10214",
     "value" "30: Gene associated with autosomal recessive phenotype",
     "id" "10214"},
    "customfield_11330" nil,
    "description"
    "ISCA Gene Curation\r\nSYMBOL: CEP78\r\nALIASES: C9orf81, CRDHL, IP63\r\n",
    "customfield_11730"
    [{"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=erica.f.andersen%40aruplab.com",
      "name" "erica.f.andersen@aruplab.com",
      "key" "erica.f.andersen@aruplab.com",
      "emailAddress" "erica.f.andersen@aruplab.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Erica Andersen",
      "active" true,
      "timeZone" "America/Denver"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=tbrandt%40genedx.com",
      "name" "tbrandt@genedx.com",
      "key" "tbrandt@genedx.com",
      "emailAddress" "tbrandt@genedx.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Tracy Brandt",
      "active" true,
      "timeZone" "America/New_York"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=cao.yang%40wustl.edu",
      "name" "cao.yang@wustl.edu",
      "key" "cao.yang@mayo.edu",
      "emailAddress" "cao.yang@wustl.edu",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10173",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10173",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10173",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10173"},
      "displayName" "Yang Cao",
      "active" true,
      "timeZone" "America/New_York"}],
    "customfield_10537" "NC_000009.12",
    "resolution"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/resolution/16",
     "id" "16",
     "description" "Work on the issue is complete.",
     "name" "Complete"},
    "customfield_10331" nil,
    "aggregatetimeoriginalestimate" nil}}
  {"expand" "operations,editmeta,changelog,transitions,renderedFields",
   "id" "53248",
   "self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/53248",
   "key" "ISCA-24340",
   "fields"
   {"customfield_10141" nil,
    "customfield_10184"
    "Kashevarova et al (2014) identified intragenic CNTN6 deletions predicted to result in intellectual disability (ID) and developmental delay (DD) in two siblings and unrelated individual using the Agilent 44 K and 60 K\r\narrays.\r\n\r\nA 295 kb deletion encompassing exons 3-23 of CNTN6 were detected in two siblings with DD, ID, an abnormal skull shape and facial dysmorphism. Parental studies were not available.\r\nThe individual with a 271.9 kb deletion of CNTN6, involving exons 21-23, had motor DD, ID, atypical autism, and speech delay. This deletion was inherited from an apparently healthy father.\r\n\r\nIn addition, the same author described a 369 kb microdeletion at 3p26.3 overlapping with CNTN6 in a patient with moderate ID, dysarthria, and attention deficit hyperactivity disorder (ADHD). Parental studies were not available (PMID: 24291026).\r\n",
    "customfield_10193" nil,
    "customfield_11436" nil,
    "created" "2011-06-21T13:53:21.000-0400",
    "customfield_10148" nil,
    "reporter"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=church",
     "name" "church",
     "key" "church",
     "emailAddress" "church@ncbi.nlm.nih.gov",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Church, Deanna",
     "active" true,
     "timeZone" "America/New_York"},
    "customfield_10187" " 27166760 ",
    "progress" {"progress" 0, "total" 0},
    "aggregatetimespent" nil,
    "aggregateprogress" {"progress" 0, "total" 0},
    "customfield_10230" nil,
    "priority"
    {"self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/priority/4",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/priorities/minor.png",
     "name" "Normal",
     "id" "4"},
    "customfield_10166"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10178",
     "value" "0",
     "id" "10178"},
    "customfield_10169" nil,
    "versions" [],
    "customfield_10126" nil,
    "customfield_10195" 1134342.0,
    "aggregatetimeestimate" nil,
    "customfield_10334" nil,
    "customfield_10333" nil,
    "customfield_10167" nil,
    "timeestimate" nil,
    "customfield_10198"
    "The CNTN6 gene is a neural adhesion molecule of the contactin subgroup of the immunoglobulin superfamily and functions as a cell adhesion molecule, which may contribute to the formation of axon connections in the developing nervous system. It has been suggested that these genes participate in pathways that are important for correct brain development. \r\nThe CNTN6 gene is located in the region which includes several more genes (CNTN4, CRBN, CHL1) involved in the clinical picture of the distal 3p deletion syndrome [MIM: 613792].\r\nIn mice, contactin genes are thought to participate in embryonic development and postnatal brain maturation. Moreover, Cntn6−/− deficient mice have impaired motor coordination and abnormal apical dendrite projections of deep layer pyramidal neurons in the visual cortex [PMIDs: 19672956 and 18046458].\r\nIn the literature, single copy loss in the 3p26.3 region involving entire CNTN6 gene deletions or intragenic CNTN6 deletions/duplications have been reported in individuals with variable clinical manifestation of neurodevelopmental disorders (NDDs), including autism spectrum disorder (ASD), intellectual disability (ID), developmental delay (DD), seizures (SZs), and attention deficit order (ADHD). The copy number deletions involving this gene were mostly inherited from an unaffected parent. Familial segregations of the CNTN6 deletions and intragenic duplications were also reported. However, parental studies were not available for the majority of cases.\r\nThere are more than 40 CNTN6 entire gene or intragenic deletions in the DECIPHER database. These CNVs have also been reported in some phenotypically normal individuals in the databases of genomic variants. \r\n\r\nTherefore, it remains unclear whether the expression of CNTN6 gene has been altered in reported individuals as there is a lack of published functional studies of these CNVs.\r\n",
    "customfield_10147" "https://omim.org/entry/607220",
    "resolutiondate" "2017-10-18T00:37:42.000-0400",
    "customfield_11635" 0.0,
    "customfield_10160" "chr3:1134342-1445292",
    "customfield_11430" "0|i0efvb:",
    "fixVersions" [],
    "customfield_10030" "CNTN6",
    "customfield_10191" nil,
    "customfield_11435" nil,
    "project"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/project/10160",
     "id" "10160",
     "key" "ISCA",
     "name" "ISCA",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?pid=10160&avatarId=10020",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=small&pid=10160&avatarId=10020",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=xsmall&pid=10160&avatarId=10020",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=medium&pid=10160&avatarId=10020"}},
    "customfield_10189" "26257835",
    "customfield_11332" nil,
    "timeoriginalestimate" nil,
    "customfield_10194" nil,
    "lastViewed" "2017-10-23T18:14:00.336-0400",
    "customfield_10190"
    "Hu et al (2015) studied of 3,724 individuals with multiple congenital anomalies, heart defect, short stature, developmental delay (DD), intellectual disability (ID), autism spectrum disorder (AS), and seizures (SZs) using NimbleGen 135K oligonucleotide array. The authors reported 3p26.3 copy number gains encompassing CNTN6 and additional genes (CHL1/CNTN6 and CHL1/CNTN6/CNTN4, respectively) in only two individuals with NDDs. The CHL1/CNTN6 duplication detected in an individual with obesity, ADHD, and bipolar was inherited from mother with psychiatric problem. Parental study was not available for the CHL1/CNTN6/CNTN4 duplication detected in an individual with attention deficit hyperactivity disorder, obsessive–compulsive disorder, and additional physical abnormalities.",
    "customfield_10534" "+",
    "customfield_10180" "2017-08-11 13:56:41.637",
    "customfield_10201" nil,
    "customfield_10152"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10153",
     "value" "Uncertain",
     "id" "10153"},
    "summary" "Initial load of genes from NCBI annotation run 37.2",
    "creator"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=church",
     "name" "church",
     "key" "church",
     "emailAddress" "church@ncbi.nlm.nih.gov",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Church, Deanna",
     "active" true,
     "timeZone" "America/New_York"},
    "customfield_10181"
    "1_*:*_1_*:*_193800845853_*|*_6_*:*_1_*:*_0_*|*_10024_*:*_1_*:*_1322029293_*|*_10023_*:*_1_*:*_4499786337",
    "labels" ["ClinicalReview"],
    "customfield_10335" nil,
    "timespent" nil,
    "workratio" -1,
    "customfield_10536" "Jan 2017 interim GRCh38.p10",
    "customfield_10161" nil,
    "status"
    {"self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/status/6",
     "description"
     "The issue is considered finished, the resolution is correct. Issues which are closed can be reopened.",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/statuses/closed.png",
     "name" "Closed",
     "id" "6",
     "statusCategory"
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/statuscategory/3",
      "id" 3,
      "key" "done",
      "colorName" "green",
      "name" "Done"}},
    "subtasks" [],
    "customfield_11630" nil,
    "customfield_10144" nil,
    "customfield_10196" nil,
    "customfield_10164"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10170",
     "value" "no",
     "id" "10170"},
    "customfield_10535" 978021.0,
    "customfield_10192" nil,
    "customfield_11331" nil,
    "customfield_10185" "26257835",
    "customfield_10149"
    "1838307:9486763:12477932:14592966:15489334:19086053:19509545:20339536:20379614:20398908:21079607",
    "customfield_11431" nil,
    "customfield_10188"
    "Mercati et al (2017) studied a cohort of 1,534 unrelated individuals with autism spectrum disorder (ASD) and 8,936 controls using Illumina SNP arrays for copy number variations (CNVs). In addition, 212 unrelated individuals with ASD and 217 controls were screened using Sanger sequencing for single nucleotide variants (SNVs) in all exons of CNTN6. Finally, replication whole genome sequencing results were analyzed in a sample of 289 individuals with ASD (200 trios and 89 sib pairs) for SNVs.\r\n\r\nThe authors also accessed to the Brain & Body Genetic Resource Exchange (BBGRE version 3.0;https://bbgre.brc.iop.kcl.ac.uk/) database including 5,891 patients (776 with ASD). They identified CNTN6 deletions in 14/5891 individuals with a significant excess of CNTN6 deletions in patients with ASD (6/776; 0.77%; P = 0.02). This excess of CNTN6 deletions in ASD was even more significant when only small deletions were considered. There were small CNTN6 deletions in 7/5891 individuals listed in BBGRE version 3.0 and 6/776 in patients with ASD (P = 0.002). \r\n\r\nIn this study, both deletions (6/1534 ASD (0.39%) vs 1/8936 controls (0.01%); P = 0.00006) and private coding sequence variants (18/501 ASD vs 535/33480 controls P = 0.0005) were enriched in individuals with ASD with hyperacusis. Several CNTN6 variants identified in this study were considered deleterious by at least two algorithms.\r\n\r\nAll CNVs were inherited (two deletions were transmitted by fathers with ASD). Among the SNVs, one nonsense mutation (W923*) was transmitted by a mother to her two sons with ASD and one variant (P770L) was found to be de novo in an individual with ASD.\r\n\r\nUsing an in vitro assay, they showed that some variants (G310S, I683S, P770S) could affect the promoting effect of CNTN6 on neuritogenesis, whereas others did not (S57L, T958I, R303Q, G678S)\r\n\r\nThe authors mentioned that a total of 47 CNTN6 deletions were listed among 18 506 patients (0.25%) in Decipher database (https://decipher.sanger.ac.uk/index). In contrast to the BBGRE database, the phenotype for autism wasrarely indicated, but several patients carrying CNTN6 deletions have cognitive impairments, intellectual disability, and ASD.\r\n",
    "customfield_10532" "chr3:978021-1403610",
    "watches"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/ISCA-24340/watchers",
     "watchCount" 3,
     "isWatching" false},
    "assignee"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=wahab.khan%40mssm.edu",
     "name" "wahab.khan@mssm.edu",
     "key" "wahab.khan@mssm.edu",
     "emailAddress" "wahab.khan@mssm.edu",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10175",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10175",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10175",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10175"},
     "displayName" "Wahab Khan",
     "active" true,
     "timeZone" "America/New_York"},
    "environment" nil,
    "votes"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/ISCA-24340/votes",
     "votes" 0,
     "hasVoted" false},
    "customfield_11437" nil,
    "customfield_11631" nil,
    "duedate" nil,
    "issuelinks" [],
    "customfield_10157" "https://www.ncbi.nlm.nih.gov/gene/27255",
    "updated" "2017-10-18T19:54:49.000-0400",
    "customfield_10533" "+",
    "customfield_10332" nil,
    "components"
    [{"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/component/10282",
      "id" "10282",
      "name" "chr3"}],
    "customfield_10156"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10171",
     "value" "protein-coding",
     "id" "10171"},
    "customfield_10200" nil,
    "customfield_10150" nil,
    "customfield_10145" "3p26.3",
    "customfield_10158" "NC_000003.11",
    "customfield_10538" nil,
    "customfield_10531" nil,
    "customfield_10183" "25606055 ",
    "customfield_10168" nil,
    "customfield_11632" nil,
    "customfield_10199"
    "In the literature, limited number of individuale been reported with entire CNTN6 duplications. Hu et al (2017) (PMID: 26257835) reported two individuals with variable manifestations of NDDs with CHL1/CNTN6 and CHL1/CNTN6/CNTN4, respectively.\r\n\r\nThere are CNTN6 entire gene duplications in the DECIPHER database as well as in the databases of genomic variants. Therefore, it remains unclear whether the expression of CNTN6 gene has been altered in reported individuals as there is a lack of published functional studies of these CNVs in the databases of genomic variants. \r\n\r\n ",
    "customfield_10143" nil,
    "customfield_10197" nil,
    "issuetype"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issuetype/31",
     "id" "31",
     "description" "Gene curation for ISCA group",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/issuetypes/genericissue.png",
     "name" "ISCA Gene Curation",
     "subtask" false},
    "customfield_10186"
    "Hu et al (2015) studied of 3,724 individuals with multiple congenital anomalies, heart defect, short stature, developmental delay (DD), intellectual disability (ID), autism spectrum disorder (AS), and seizures (SZs) using NimbleGen 135K oligonucleotide array. The authors reported 3p26.3 CNVs encompassing CNTN6 in 14 individuals (0.4%). Thirteen of the 14 individuals have variable clinical manifestation of neurodevelopmental disorders (NDDs), including ASD, DD, SZs, and attention deficit order (ADHD). The remaining one individual with heart block was a newborn whose development and behavior was normal at 1 year old. In addition, seven of the 14 individuals have dysmorphic features. Family history was available for 13 of the 14 individuals. Twelve families had multiple members with NDDs and neuropsychiatric disorders including ADHD, SZs, ASD, ID, schizophrenia, depression, anxiety, learning disability, and bipolar disorder.\r\n\r\nSeven of the 14 individuals had single copy loss in the 3p26.3 region involving entire CNTN6 gene deletions (2 individuals) or intragenic CNTN6 deletions (5 unrelated individuals, involving exon 2; exons 3-7; exons 5-12; exons 8-23,and exons 2-23, respectively). Parental studies were available in only one individual. The proband and her sister with SZs had a paternally inherited intragenic deletion of CNTN6 encompassing exons 8-23. Although the father had an apparently normal phenotype, the authors suggested an incomplete penetrance.\r\n\r\nIn addition, five of the 14 individuals had intragenic duplications of CNTN6 ranged from 93.95 kb to 1.23 Mb (upstream and exons 1-2; upstream and exons 1-17; exons 2-7; exons 3-23 and downstream; and exons 4-23 and downstream, respectively). No other known pathogenic CNVs or CNVs with unclear clinical significance were observed in any of these individuals. The upstream and exons 1-2 duplication was inherited from phenotypically normal mother. The exons 3–23 and downstream duplication was paternally inherited. The father had bipolar and ADHD. Parental studies were not available in the remaining individuals. ",
    "customfield_11633" nil,
    "customfield_10146" nil,
    "customfield_10165"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10183",
     "value" "1",
     "id" "10183"},
    "customfield_11330" nil,
    "description" "ISCA Gene Curation\nSYMBOL: CNTN6\nALIASES: NB3\n",
    "customfield_11730"
    [{"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=erica.f.andersen%40aruplab.com",
      "name" "erica.f.andersen@aruplab.com",
      "key" "erica.f.andersen@aruplab.com",
      "emailAddress" "erica.f.andersen@aruplab.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Erica Andersen",
      "active" true,
      "timeZone" "America/Denver"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=skantarci777%40gmail.com",
      "name" "skantarci777@gmail.com",
      "key" "skantarci@mednet.ucla.edu",
      "emailAddress" "skantarci777@gmail.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Sibel Kantarci",
      "active" true,
      "timeZone" "America/New_York"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=wahab.khan%40mssm.edu",
      "name" "wahab.khan@mssm.edu",
      "key" "wahab.khan@mssm.edu",
      "emailAddress" "wahab.khan@mssm.edu",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10175",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10175",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10175",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10175"},
      "displayName" "Wahab Khan",
      "active" true,
      "timeZone" "America/New_York"}],
    "customfield_10537" "NC_000003.12",
    "resolution"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/resolution/16",
     "id" "16",
     "description" "Work on the issue is complete.",
     "name" "Complete"},
    "customfield_10331" nil,
    "aggregatetimeoriginalestimate" nil}}
  {"expand" "operations,editmeta,changelog,transitions,renderedFields",
   "id" "33747",
   "self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/33747",
   "key" "ISCA-4891",
   "fields"
   {"customfield_10141" nil,
    "customfield_10184"
    "Fernandez et al (2004) reported a de novo balanced translocation involving chromosomes 3 and 10 with breakpoint in chromosome 3p that disrupts the 5' UTR of contactin 4 (CNTN4) in a patient with developmental delay and characteristic physical features of the distal 3p deletion syndrome [MIM: 613792]. The authors suggested that disruption of a single copy of CNTN4 is sufficient to confer clinical features of the 3p deletion syndrome phenotype, including developmental delay.",
    "customfield_10193" nil,
    "customfield_11436" nil,
    "created" "2011-06-21T07:40:19.000-0400",
    "customfield_10148" nil,
    "reporter"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=church",
     "name" "church",
     "key" "church",
     "emailAddress" "church@ncbi.nlm.nih.gov",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Church, Deanna",
     "active" true,
     "timeZone" "America/New_York"},
    "customfield_10187" "21308999",
    "progress" {"progress" 0, "total" 0},
    "aggregatetimespent" nil,
    "aggregateprogress" {"progress" 0, "total" 0},
    "customfield_10230" nil,
    "priority"
    {"self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/priority/4",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/priorities/minor.png",
     "name" "Normal",
     "id" "4"},
    "customfield_10166"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10178",
     "value" "0",
     "id" "10178"},
    "customfield_10169"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10192",
     "value" "Loss of function score",
     "id" "10192"},
    "versions" [],
    "customfield_10126" nil,
    "customfield_10195" 2140550.0,
    "aggregatetimeestimate" nil,
    "customfield_10334" nil,
    "customfield_10333" nil,
    "customfield_10167" nil,
    "timeestimate" nil,
    "customfield_10198"
    "Currently, CNTN4 is not associated with an OMIM phenotype. The literature suggests that disruptions of a single copy of CNTN4 may play a role in a pathogenic mechanism for this gene. Disruptions of CNTN4 via chromosomal rearrangements, copy number variations, and missense mutations have been reported in individuals with various neurodevelopmental disorders, including autism spectrum disorder. However, given copy number deletion of this gene has been observed in the general population as noted in the Database of Genomic Variants (DGV) and due to parental inheritance and a weak evidence of family segregation with clinical phenotype, the clinical significance of CNTN4 haploinsufficiency remains uncertain. \r\n\r\nAdditionally, in a study comparing a large cohort of children with ID and/or DD to unaffected adult controls, the incidence of observed deletions of CNTN4 was 15/15,767 in cases vs. 4/8,329 controls, which failed to reach statistical significance with a p value of 0.159 (PMID:21841781)\r\n\r\n",
    "customfield_10147" "https://omim.org/entry/607280",
    "resolutiondate" "2017-10-18T00:38:01.000-0400",
    "customfield_11635" 0.997,
    "customfield_10160" "chr3:2140550-3099645",
    "customfield_11430" "0|i04vyn:",
    "fixVersions" [],
    "customfield_10030" "CNTN4",
    "customfield_10191" nil,
    "customfield_11435" nil,
    "project"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/project/10160",
     "id" "10160",
     "key" "ISCA",
     "name" "ISCA",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?pid=10160&avatarId=10020",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=small&pid=10160&avatarId=10020",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=xsmall&pid=10160&avatarId=10020",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=medium&pid=10160&avatarId=10020"}},
    "customfield_10189" " 22750301",
    "customfield_11332" nil,
    "timeoriginalestimate" nil,
    "customfield_10194" nil,
    "lastViewed" "2017-10-18T09:48:57.298-0400",
    "customfield_10190"
    "Guo et al (2012) identified large duplications involving CNTN4 in two individuals with autism using Illumina HumanCNV370-Quad BeadChip . The 2.4 Mb gain interval encompassed several other genes; however, 1.6 Mb gain disrupted only CNTN4 and CNTN6.\r\n",
    "customfield_10534" "+",
    "customfield_10180" "2011-11-11 16:56:08.81",
    "customfield_10201" nil,
    "customfield_10152"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10190",
     "value" "Target: Increase probe density",
     "id" "10190"},
    "summary" "Initial load of genes from NCBI annotation run 37.2",
    "creator"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=church",
     "name" "church",
     "key" "church",
     "emailAddress" "church@ncbi.nlm.nih.gov",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Church, Deanna",
     "active" true,
     "timeZone" "America/New_York"},
    "customfield_10181"
    "1_*:*_1_*:*_14028558680_*|*_4_*:*_2_*:*_74240266_*|*_6_*:*_3_*:*_171597177280_*|*_10024_*:*_2_*:*_13945047060_*|*_10023_*:*_3_*:*_35247_*|*_10025_*:*_1_*:*_3487",
    "labels" ["ClinicalReview" "LitReview" "RBpathogenic"],
    "customfield_10335" nil,
    "timespent" nil,
    "workratio" -1,
    "customfield_10536" "Jan 2017 interim GRCh38.p10",
    "customfield_10161" nil,
    "status"
    {"self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/status/6",
     "description"
     "The issue is considered finished, the resolution is correct. Issues which are closed can be reopened.",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/statuses/closed.png",
     "name" "Closed",
     "id" "6",
     "statusCategory"
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/statuscategory/3",
      "id" 3,
      "key" "done",
      "colorName" "green",
      "name" "Done"}},
    "subtasks" [],
    "customfield_11630" nil,
    "customfield_10144" nil,
    "customfield_10196"
    "Increased coverage may be appropriate while we learn more about the potential haploinsufficiency of this gene",
    "customfield_10164"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10169",
     "value" "yes",
     "id" "10169"},
    "customfield_10535" 2098771.0,
    "customfield_10192" nil,
    "customfield_11331" nil,
    "customfield_10185" "18349135",
    "customfield_10149"
    ">too many PMIDs for Jira; see Gene page for info",
    "customfield_11431" nil,
    "customfield_10188"
    "Cottrell et al (2011) reported a deletion at 3p26.3 encompassing the 5′ end of CNTN4 (~535 kb) in an individual with autism using array comparative genome hybridization (aCGH). This deletion was inherited from a phenotypically normal mother. \r\n\r\nFurther, they sequenced CNTN4 in a cohort of 75 individuals with autism spectrum disorder (ASD) and 107 controls. Unique and evolutionary conserved nonsynonymous missense variants were identified in 4/75 unrelated individuals with an ASD, as well as in 1/107 controls. However, these data did not reach statistical significance, nor did the variants segregate with disease within all of the ASD families. The authors did not detect any difference in binding efficiencies of the murine CNTN4Ig1-4 fragments containing conserved variants found in two ASD families at amino acid positions 178 or 221.",
    "customfield_10532" "chr3:2098771-3059080",
    "watches"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/ISCA-4891/watchers",
     "watchCount" 4,
     "isWatching" false},
    "assignee"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=wahab.khan%40mssm.edu",
     "name" "wahab.khan@mssm.edu",
     "key" "wahab.khan@mssm.edu",
     "emailAddress" "wahab.khan@mssm.edu",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10175",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10175",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10175",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10175"},
     "displayName" "Wahab Khan",
     "active" true,
     "timeZone" "America/New_York"},
    "environment" nil,
    "votes"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/ISCA-4891/votes",
     "votes" 0,
     "hasVoted" false},
    "customfield_11437" nil,
    "customfield_11631" nil,
    "duedate" nil,
    "issuelinks" [],
    "customfield_10157" "https://www.ncbi.nlm.nih.gov/gene/152330",
    "updated" "2017-10-18T00:38:01.000-0400",
    "customfield_10533" "+",
    "customfield_10332" nil,
    "components"
    [{"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/component/10282",
      "id" "10282",
      "name" "chr3"}],
    "customfield_10156"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10171",
     "value" "protein-coding",
     "id" "10171"},
    "customfield_10200" nil,
    "customfield_10150" nil,
    "customfield_10145" "3p26.3-p26.2",
    "customfield_10158" "NC_000003.11",
    "customfield_10538" nil,
    "customfield_10531" nil,
    "customfield_10183" "15106122",
    "customfield_10168" nil,
    "customfield_11632" nil,
    "customfield_10199"
    "At this time there is no evidence that supports the triplosensitivity of CNTN4.\r\n\r\nOf note, In a study comparing a large cohort of children with ID and/or DD to unaffected adult controls, the incidence of observed gains of CNTN4 was  15/15,767 cases vs 17/8,329 controls (PMID:21841781)",
    "customfield_10143" nil,
    "customfield_10197" nil,
    "issuetype"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issuetype/31",
     "id" "31",
     "description" "Gene curation for ISCA group",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/issuetypes/genericissue.png",
     "name" "ISCA Gene Curation",
     "subtask" false},
    "customfield_10186"
    "Roohi et al (2009) identified CNTN4 disruptions via an intragenic deletion (~654 kb, involving exons 2-6 of 25) in two siblings and an intragenic duplication (~791 kb, involving exons 1-5 of 25) in another unrelated individual with autism spectrum disorder (ASD) using whole genome array comparative genomic hybridization (aCGH). However, none of these individuals with intragenic copy number variations (CNVs) of CNTN4 demonstrated the classical distal 3p deletion syndrome phenotype. Of note, in this study, CNVs disrupting CNTN4 were all inherited from fathers without a history of ASD. In addition, a third affected sibling with ASD in the family with intragenic deletion did not carry the deletion.\r\n\r\nFurther molecular characterization of the CNVs revealed that they resulted from Alu Y mediated unequal recombination.\r\n\r\nThe authors stated that there have been a few rare reports of CNVs affecting CNTN4 in normal individuals as well (Database of Genomic Variants, http://projects.tcag.ca/variation/). Therefore, they offered incomplete penetrance of disruption of the gene. \r\n",
    "customfield_11633" nil,
    "customfield_10146" nil,
    "customfield_10165"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10183",
     "value" "1",
     "id" "10183"},
    "customfield_11330" nil,
    "description"
    "ISCA Gene Curation\nSYMBOL: CNTN4\nALIASES: AXCAM, BIG-2\n",
    "customfield_11730"
    [{"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=erica.f.andersen%40aruplab.com",
      "name" "erica.f.andersen@aruplab.com",
      "key" "erica.f.andersen@aruplab.com",
      "emailAddress" "erica.f.andersen@aruplab.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Erica Andersen",
      "active" true,
      "timeZone" "America/Denver"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=erin.baldwin%40aruplab.com",
      "name" "erin.baldwin@aruplab.com",
      "key" "erin.baldwin@aruplab.com",
      "emailAddress" "erin.baldwin@aruplab.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Erin Baldwin",
      "active" true,
      "timeZone" "America/New_York"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=skantarci777%40gmail.com",
      "name" "skantarci777@gmail.com",
      "key" "skantarci@mednet.ucla.edu",
      "emailAddress" "skantarci777@gmail.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Sibel Kantarci",
      "active" true,
      "timeZone" "America/New_York"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=wahab.khan%40mssm.edu",
      "name" "wahab.khan@mssm.edu",
      "key" "wahab.khan@mssm.edu",
      "emailAddress" "wahab.khan@mssm.edu",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10175",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10175",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10175",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10175"},
      "displayName" "Wahab Khan",
      "active" true,
      "timeZone" "America/New_York"}],
    "customfield_10537" "NC_000003.12",
    "resolution"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/resolution/16",
     "id" "16",
     "description" "Work on the issue is complete.",
     "name" "Complete"},
    "customfield_10331" nil,
    "aggregatetimeoriginalestimate" nil}}
  {"expand" "operations,editmeta,changelog,transitions,renderedFields",
   "id" "35441",
   "self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/35441",
   "key" "ISCA-6584",
   "fields"
   {"customfield_10141" nil,
    "customfield_10184"
    "Using exome sequencing Tsurusaki et al (2012) identified 3 mutations in ARID1A in a study designed to target genes encoding sub-units of the SWItch/Sucrose NonFermenting (SWI/SNF) complex in patients with Coffin-Siris Syndrome (CSS). These included one frameshift and 2 premature termination mutations. 1 of the nonsense variants was de novo (subject 8); parental samples for the remaining 2 variants were unavailable. cDNA analysis of lymphoblastoid cell lines from subject 6 (the nonsense variant without available parental samples) showed that the mutant transcript was subject to nonsense-mediated decay. The authors proposed that haploinsufficiency of ARID1A must be able to cause CSS as the mutations were predicted to cause protein truncation.  Additional clinical information for these three individuals is available in PMID: 23637025.",
    "customfield_10193" nil,
    "customfield_11436" nil,
    "created" "2011-06-21T07:56:17.000-0400",
    "customfield_10148" nil,
    "reporter"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=church",
     "name" "church",
     "key" "church",
     "emailAddress" "church@ncbi.nlm.nih.gov",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Church, Deanna",
     "active" true,
     "timeZone" "America/New_York"},
    "customfield_10187" "23906836",
    "progress" {"progress" 0, "total" 0},
    "aggregatetimespent" nil,
    "aggregateprogress" {"progress" 0, "total" 0},
    "customfield_10230" nil,
    "priority"
    {"self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/priority/4",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/priorities/minor.png",
     "name" "Normal",
     "id" "4"},
    "customfield_10166"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10178",
     "value" "0",
     "id" "10178"},
    "customfield_10169"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10192",
     "value" "Loss of function score",
     "id" "10192"},
    "versions" [],
    "customfield_10126" nil,
    "customfield_10195" 2.7022522E7,
    "aggregatetimeestimate" nil,
    "customfield_10334"
    "LINE 1: STATUS=Confirmed DD Gene\tCONSEQUENCES=Loss of function\tINHERITANCE=Monoallelic\n",
    "customfield_10333"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10244",
     "value" "Loss of function",
     "id" "10244"},
    "customfield_10167" nil,
    "timeestimate" nil,
    "customfield_10198"
    "Coffin-Siris syndrome is a rare congenital anomaly syndrome characterized by growth deficiency, intellectual disability, microcephaly, coarse facial features and hypoplastic nail of the fifth finger and/or toe.  Variants reported in the literature to date have been nonsense or frameshift, though many have been observed in the context of somatic mosaicism.  One hypothesis put forth by Santen et al. is that heterozygous truncating germline variants in ARID1A may be embryonically lethal; these authors cite the work of Gao et al. (2008) showing this to be the case in mice.",
    "customfield_10147" "https://omim.org/entry/603024",
    "resolutiondate" "2017-10-12T14:59:12.000-0400",
    "customfield_11635" 1.0,
    "customfield_10160" "chr1:27022522-27108601",
    "customfield_11430" "0|i066k7:",
    "fixVersions" [],
    "customfield_10030" "ARID1A",
    "customfield_10191" nil,
    "customfield_11435" nil,
    "project"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/project/10160",
     "id" "10160",
     "key" "ISCA",
     "name" "ISCA",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?pid=10160&avatarId=10020",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=small&pid=10160&avatarId=10020",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=xsmall&pid=10160&avatarId=10020",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/projectavatar?size=medium&pid=10160&avatarId=10020"}},
    "customfield_10189" nil,
    "customfield_11332" "22426308; 22426309",
    "timeoriginalestimate" nil,
    "customfield_10194" nil,
    "lastViewed" "2017-10-13T12:35:49.404-0400",
    "customfield_10190" nil,
    "customfield_10534" "+",
    "customfield_10180" "2013-03-14 11:47:58.487",
    "customfield_10201" nil,
    "customfield_10152"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10189",
     "value" "Target: Exon-level",
     "id" "10189"},
    "summary" "Initial load of genes from NCBI annotation run 37.2",
    "creator"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=church",
     "name" "church",
     "key" "church",
     "emailAddress" "church@ncbi.nlm.nih.gov",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Church, Deanna",
     "active" true,
     "timeZone" "America/New_York"},
    "customfield_10181"
    "1_*:*_1_*:*_54542761490_*|*_4_*:*_1_*:*_3488312247_*|*_6_*:*_2_*:*_135377669853_*|*_10023_*:*_2_*:*_12806_*|*_10025_*:*_2_*:*_5768618520",
    "labels" ["DBnonsense" "LitReview"],
    "customfield_10335"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10250",
     "value" "Yes",
     "id" "10250"},
    "timespent" nil,
    "workratio" -1,
    "customfield_10536" "Jan 2017 interim GRCh38.p10",
    "customfield_10161" nil,
    "status"
    {"self" "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/status/6",
     "description"
     "The issue is considered finished, the resolution is correct. Issues which are closed can be reopened.",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/statuses/closed.png",
     "name" "Closed",
     "id" "6",
     "statusCategory"
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/statuscategory/3",
      "id" 3,
      "key" "done",
      "colorName" "green",
      "name" "Done"}},
    "subtasks" [],
    "customfield_11630" nil,
    "customfield_10144" nil,
    "customfield_10196" nil,
    "customfield_10164"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10170",
     "value" "no",
     "id" "10170"},
    "customfield_10535" 2.6696031E7,
    "customfield_10192" nil,
    "customfield_11331"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10620",
     "value" "AD",
     "id" "10620"},
    "customfield_10185" "23929686",
    "customfield_10149"
    ">too many PMIDs for Jira; see Gene page for info",
    "customfield_11431" nil,
    "customfield_10188"
    "Wieczorek et al. 2013 describe a de novo nonsense variant in an individual with a clinical diagnosis of Coffin-Siris syndrome (Individual K2435) identified by whole exome sequencing.  The authors note that this allele was \"detected in a lower proportion than the wild-type allele, indicating the presence of somatic mosaicism in the individual.\"",
    "customfield_10532" "chr1:26696031-26782110",
    "watches"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/ISCA-6584/watchers",
     "watchCount" 6,
     "isWatching" false},
    "assignee"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=eriggs%40geisinger.edu",
     "name" "eriggs@geisinger.edu",
     "key" "erin.riggs@emory.edu",
     "emailAddress" "eriggs@geisinger.edu",
     "avatarUrls"
     {"48x48"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
      "24x24"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
      "16x16"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
      "32x32"
      "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
     "displayName" "Erin Riggs",
     "active" true,
     "timeZone" "America/Chicago"},
    "environment" nil,
    "votes"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issue/ISCA-6584/votes",
     "votes" 0,
     "hasVoted" false},
    "customfield_11437" nil,
    "customfield_11631" nil,
    "duedate" nil,
    "issuelinks" [],
    "customfield_10157" "https://www.ncbi.nlm.nih.gov/gene/8289",
    "updated" "2017-10-12T17:36:22.000-0400",
    "customfield_10533" "+",
    "customfield_10332"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10232",
     "value" "Confirmed DD Gene",
     "id" "10232"},
    "components"
    [{"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/component/10280",
      "id" "10280",
      "name" "chr1"}],
    "customfield_10156"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10171",
     "value" "protein-coding",
     "id" "10171"},
    "customfield_10200" "614607",
    "customfield_10150"
    "https://www.ncbi.nlm.nih.gov/books/NBK131811/?term=ARID1A",
    "customfield_10145" "1p36.11",
    "customfield_10158" "NC_000001.10",
    "customfield_10538" nil,
    "customfield_10531" nil,
    "customfield_10183" "22426308",
    "customfield_10168" nil,
    "customfield_11632" nil,
    "customfield_10199"
    "Bidart et al. 2017 (PMID: 27906199) describe 4 individuals with de novo duplications involving ARID1A (and other genes).  The authors classified the phenotypes of the individuals as \"similar\" with \"microcephaly,intellectual disability, delayed motor milestones, hand and foot anomalies, growth impairment, constipation, frequent airway infections, dysmorphic facial features, and stereotypies.\"  The minimal critical region between these 4 individuals included all of ARID1A as well as part of the PIGV gene.  Because these duplications all include other genes, we will not formally count this as evidence for triplosensitivity.   Additional evidence is needed to evaluate the potential consequences of full gene duplications of ARID1A.",
    "customfield_10143" nil,
    "customfield_10197" nil,
    "issuetype"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/issuetype/31",
     "id" "31",
     "description" "Gene curation for ISCA group",
     "iconUrl"
     "https://ncbijira.ncbi.nlm.nih.gov/images/icons/issuetypes/genericissue.png",
     "name" "ISCA Gene Curation",
     "subtask" false},
    "customfield_10186"
    "Santen et al. 2013 evaluated 63 patients with clinical diagnoses of Coffin-Siris syndrome via Sanger sequencing for variants in six genes previously associated with Coffin-Siris syndrome, including ARID1A.  They identified 4 variants in ARID1A: two nonsense and two frameshift.  One of the nonsense and one of the frameshift variants were de novo; the mother was unavailable for the second nonsense variant (not detected in father), and neither parent was available for the second frameshift.  Of note, all 4 of these variants appeared to be mosaic in lymphocytes.  These authors also suggested that the sequencing reads from the variant alleles published in the Tsurusaki paper of two variants appeared to have lower peaks than the reference allele; they hypothesized that these variants might be mosaic as well.",
    "customfield_11633" nil,
    "customfield_10146" nil,
    "customfield_10165"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10185",
     "value" "3",
     "id" "10185"},
    "customfield_11330"
    "Mental retardation, autosomal dominant 14; Coffin-Siris syndrome",
    "description"
    "ISCA Gene Curation\nSYMBOL: ARID1A\nALIASES: B120, BAF250, BAF250a, BM029, C1orf4, CSS2, ELD, MRD14, OSA1, P270, SMARCF1, hELD, hOSA1\n",
    "customfield_11730"
    [{"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=burnsir%40labcorp.com",
      "name" "burnsir@labcorp.com",
      "key" "burnsir@labcorp.com",
      "emailAddress" "Burnsir@LabCorp.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Burnside, Rachel",
      "active" true,
      "timeZone" "America/New_York"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=dominic.mcmullan%40bwhct.nhs.uk",
      "name" "dominic.mcmullan@bwhct.nhs.uk",
      "key" "dominic.mcmullan@bwhct.nhs.uk",
      "emailAddress" "dominic.mcmullan@bwhct.nhs.uk",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Dominic McMullan",
      "active" true,
      "timeZone" "America/New_York"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=erica.f.andersen%40aruplab.com",
      "name" "erica.f.andersen@aruplab.com",
      "key" "erica.f.andersen@aruplab.com",
      "emailAddress" "erica.f.andersen@aruplab.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Erica Andersen",
      "active" true,
      "timeZone" "America/Denver"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=erin.baldwin%40aruplab.com",
      "name" "erin.baldwin@aruplab.com",
      "key" "erin.baldwin@aruplab.com",
      "emailAddress" "erin.baldwin@aruplab.com",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Erin Baldwin",
      "active" true,
      "timeZone" "America/New_York"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=eriggs%40geisinger.edu",
      "name" "eriggs@geisinger.edu",
      "key" "erin.riggs@emory.edu",
      "emailAddress" "eriggs@geisinger.edu",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Erin Riggs",
      "active" true,
      "timeZone" "America/Chicago"}
     {"self"
      "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/user?username=sabradley%40geisinger.edu",
      "name" "sabradley@geisinger.edu",
      "key" "sabradley@geisinger.edu",
      "emailAddress" "sabradley@geisinger.edu",
      "avatarUrls"
      {"48x48"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?avatarId=10182",
       "24x24"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=small&avatarId=10182",
       "16x16"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=xsmall&avatarId=10182",
       "32x32"
       "https://ncbijira.ncbi.nlm.nih.gov/secure/useravatar?size=medium&avatarId=10182"},
      "displayName" "Scott Bradley",
      "active" true,
      "timeZone" "America/New_York"}],
    "customfield_10537" "NC_000001.11",
    "resolution"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/resolution/16",
     "id" "16",
     "description" "Work on the issue is complete.",
     "name" "Complete"},
    "customfield_10331"
    {"self"
     "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/customFieldOption/10226",
     "value" "Monoallelic",
     "id" "10226"},
    "aggregatetimeoriginalestimate" nil}}]))
