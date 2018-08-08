people_count=int(input())
movie_outcome=20
ticket=5
people_outcome=0.5
income=people_count*ticket
outcome=movie_outcome+(people_outcome*people_count)
total_income=income-outcome
print(total_income)