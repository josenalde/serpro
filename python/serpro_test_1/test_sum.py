import unittest

from my_sum import sum
# also
# target = __import__("my_sum.py")
# sum = target.sum
"""
.assertEqual(a, b)	a == b
.assertTrue(x)	bool(x) is True
.assertFalse(x)	bool(x) is False
.assertIs(a, b)	a is b
.assertIsNone(x)	x is None
.assertIn(a, b)	a in b
.assertIsInstance(a, b)	isinstance(a, b)
.assertIs(), .assertIsNone(), .assertIn(), and .assertIsInstance() all have opposite methods, named .assertIsNot(), and so forth.
"""
from fractions import Fraction


class TestSum(unittest.TestCase):
    def test_list_int(self):
        """
        Test that it can sum a list of integers
        """
        data = [1, 2, 3]
        result = sum(data)
        self.assertEqual(result, 6)

    def test_list_fraction(self):
        """
        Test that it can sum a list of fractions
        """
        data = [float(Fraction(1, 4)), float(
            Fraction(1, 4)), float(Fraction(2, 5))]
        result = sum(data)
        self.assertEqual(result, 0.9)

    def test_bad_type(self):
        data = "banana"
        with self.assertRaises(TypeError):
            result = sum(data)

    def setUp(self):
        self.lst = ['1', '2', '4']

    def test_in_one(self):
        self.assertIn('1', self.lst)
        self.lst.remove('1')

    def test_in_two(self):
        self.assertIn('1', self.lst)


if __name__ == '__main__':
    unittest.main()  # python -m unittest -v test ou #python test.py
# criar uma pasta 'tests' e o unittest descobre os arquivos test_*.py
# python -m unittest discover -s tests

"""
$ python -m unittest discover -s tests -t src
unittest will change to the src/ directory, scan for all test*.py files inside the the tests directory, and execute them.
"""

"""
python -m unittest discover -s tests/integration
project/
│
├── my_app/
│   └── __init__.py
│
└── tests/
    |
    ├── unit/
    |   ├── __init__.py
    |   └── test_sum.py
    |
    └── integration/
        ├── __init__.py
        └── test_integration.py
"""
"""
class TestBasic(unittest.TestCase):
    def setUp(self): #executado antes de cada teste
        # Load test data
        self.app = App(database='fixtures/test_basic.json')

    def test_customer_count(self):
        self.assertEqual(len(self.app.customers), 100)

    def test_existence_of_customer(self):
        customer = self.app.get_customer(id=10)
        self.assertEqual(customer.name, "Org XYZ")
        self.assertEqual(customer.address, "10 Red Road, Reading")
"""
