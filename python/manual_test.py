"""
def sum(v):
    s = 0
    for i in v:
        s += i
    return s
"""

# se ok nao da erro, se errado, exibe string apos o assert AssertionError
assert (sum([1, 2, 3]) == 8), "esperado 6"
