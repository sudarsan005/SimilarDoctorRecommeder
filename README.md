# SimilarDoctorRecommeder
Code returns list of similar doctors for a given doctor attributes.

Assumptions:
This code is written based on the following assumptions
1)The number of supported languages for a doctor is 5
2)The minimum similarity required is Doctors of same speciality and after that the other factors such as Rating, Languages, Gender and City are normalized to score of 5 and then sorted based on the ranking score.


Possible Enchancements:
1) Doctors nearby constraint on a x mile radius can be added as a filter.
2) More attributes can be added like preferred provider, number of votes for rating.
3) Ranking algorithm can also include number of votes as factor and use True Naive Bayesian estimate.
4) More elaborate test cases to cover corner cases.
