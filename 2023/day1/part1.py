input_string = open('input.txt').read()
#if input_string[-1] == '\n':
 #   input_string = input_string[:-1]

def find_numbers(phrase):
    numbers = []
    for p in phrase:
        if p.isnumeric():
            numbers.append(p)
    str_answer = ''.join([numbers[0],numbers[-1]])
    answer = int(str_answer)
    return answer

test1 = '1abc2'
test2 = 'pqr3stu8vwx'
test3 = 'a1b2c3d4e5f'
test4 = 'treb7uchet'

print(find_numbers(test1))
print(find_numbers(test2))
print(find_numbers(test3))
print(find_numbers(test4))

sum = 0
sum += find_numbers(test1)
sum += find_numbers(test2)
sum += find_numbers(test3)
sum += find_numbers(test4)
print(sum)

total = 0
for s in input_string.split('\n'):
    total += find_numbers(s)
print(total)