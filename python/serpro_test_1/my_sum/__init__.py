# __init__.py significa que my_sum pode ser importado como um módulo
def sum(arg):  # qualquer iteravel (lista, tupla, conjunto etc.)
    total = 0
    for val in arg:
        total += val
    return total
