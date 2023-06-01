"""
#총 합
def convert(sum):
    sum += 1
    print(sum)
    if sum == 100:
        return sum
    return (sum + convert(sum))

print(convert(0))
"""

"""
#팩토리얼
def convert(fac):
    fac += 1
    if fac == 3:
        print(str(fac) + "! = ")
        return fac
    return (fac * convert(fac))

print(convert(0))
"""


#피보나치

def convert(f0,f1):
    print(f0)
    if f1 == 4:
        return f1
    print(f1)
    f0 += f1
    f1 += 1
    return convert(f0,f1)

print(convert(0,1))
