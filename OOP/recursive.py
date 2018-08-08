from math import fabs


def sum(num, limit):
    print("sum", num)
    if num == limit:
        return num

    return num + sum(num + 1, limit )


print(sum(1, 10))



print("------------------------")


def cashbag(money, unit, rate):

    if money <= 0:
        return 0

    if money < 1000:
        unit = money
    total = rate * (1 / 100) * unit
    rate += 0.25

    if rate >= 1.0:
        rate = 1.0
    print(total)
    return total + float(cashbag(money - unit, 1000 , rate))

print(cashbag(3000, 500, 0.25))










