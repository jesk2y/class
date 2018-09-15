def make_benefit(people, ticket_price):
    income=people*ticket_price
    outcome=180+(people*0.04)
    total_income=income-outcome
    return total_income

ticket=5
people_count=120
max=0

for i in range(0,50):
    money=make_benefit(people_count, ticket)
    if money > max:
        max=money
        best_ticket_price=ticket

    ticket=ticket-0.1
    people_count=people_count+15

print(best_ticket_price, ":", max)