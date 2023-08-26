const { sum } = require('./my-code')

describe('math functions', () => {
        /*beforeAll(() => {
            console.log('before all')
        })
        beforeEach(() => {
            console.log('before each')
        })
        afterAll(() => {
            console.log('after all')
        })
        afterEach(() => {
            console.log('after each')
        })*/
    it('sum 2 numbers', () => {
        expect(sum(1,2)).toBe(3)
    })
        it('sum 2 numbers', () => {
            expect(sum(1,2)).toBe(3)
        })
})

