

def quick(list):

    print(list)

    if len(list) == 0 :
        return []

    if len(list) == 1:
        return list

    pivot = list[0]
    left = []
    right = []

    for x in list:

        if x > pivot:
            right.append(x)
        elif x < pivot:
            left.append(x)


    return quick(left) + [pivot] + quick(right)

print("------------------------------")
print(quick([5,6,3,2,8,7,9]))