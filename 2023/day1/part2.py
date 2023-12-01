from word2number import w2n

input_string = open('input.txt').read()

def find_numbers(phrase):
    numbers = []
    for p in phrase:
        if p.isnumeric():
            numbers.append(p)
    str_answer = ''.join([numbers[0],numbers[-1]])
    answer = int(str_answer)
    return answer

test1 = 'two1nine'
test2 = 'eightwothree'
test3 = 'abcone2threexyz'
test4 = 'xtwone3four'
test5 = '4nineeightseven2'
test6 = 'zoneight234'
test7 = '7pqrstsixteen'

def words_to_numbers(phrase):
    answer = phrase.replace('one','one1one').replace('two','two2two').replace('three','three3three').replace('four','four4four').replace('five','five5five').replace('six','six6six').replace('seven','seven7seven').replace('eight','eight8eight').replace('nine','nine9nine')
    return answer

print(find_numbers(words_to_numbers(test1)))
print(find_numbers(words_to_numbers(test2)))
print(find_numbers(words_to_numbers(test3)))
print(find_numbers(words_to_numbers(test4)))
print(find_numbers(words_to_numbers(test5)))
print(find_numbers(words_to_numbers(test6)))
print(find_numbers(words_to_numbers(test7)))


sum = 0
sum += find_numbers(words_to_numbers(test1))
sum += find_numbers(words_to_numbers(test2))
sum += find_numbers(words_to_numbers(test3))
sum += find_numbers(words_to_numbers(test4))
sum += find_numbers(words_to_numbers(test5))
sum += find_numbers(words_to_numbers(test6))
sum += find_numbers(words_to_numbers(test7))

print(sum)

total = 0
for s in input_string.split('\n'):
    total += find_numbers(words_to_numbers(s))
print(total)