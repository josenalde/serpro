# built-in test runner since 2.1 (pyunit)

import unittest


class TestSum(unittest.TestCase):
    def test_sum(self):
        self.assertEqual(sum([1, 2, 3]), 6, "resultado esperado da soma: 6")

    def test_sum_tuple(self):
        self.assertEqual(sum((1, 2, 2)), 6, "resultado esperado da soma: 5")


if __name__ == '__main__':
    unittest.main()
