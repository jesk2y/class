#캐쉬백
ret = 0
use = int(input("작년 실적을 입력하세요.\n"))
if use > 500:
    ret += 500 * (0.25 * 0.01)
    use -= 500
else:
    ret += use * (0.25 * 0.01)
    use = 0

if use > 1000:
    ret += 1000 * (0.5 * 0.01)
    use -= 1000
else:
    ret += use * (0.5 * 0.01)
    use = 0

if use > 1000:
    ret += 1000 * (0.75 * 0.01)
    use -= 1000
else:
    ret += use * (0.75 * 0.01)
    use = 0

ret += use * 0.1 * 0.01

print(ret)