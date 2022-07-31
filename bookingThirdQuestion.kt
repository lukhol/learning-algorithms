// Booking need to rank hotels based on users review
// For each positive keyword that occur in review hotel gain 3 points
// For each negative keyword that occur in review hotel loos 1 point
// 
// Input:
// k - number of top hotels
// hotelIds: Array<Int> -
// positiveKeywords: String
// negativeKeywords: String
// reviews: Array<String>
// 
// Constraints:
// - if k is greater than number of unique hotel ids then just return ids of all hotels
// - size of hotelIds is always the same as reviews (hotel with index i has review in reviews on index i)
// - positiveKeywords and negativeKeywords are words separated by one empty space and there are no keywords made up of two words
// - keywords and words in reviews can be in different cases (some upper, some lower cases, some capitalized)
// - if there are two hotels with the same score then return hotel ids in sorted order (smaller first)
// - dots (.) and commas (,) should be ommited

fun topKScores(k: Int, hotelIds: Array<Int>, positiveKeywords: String, negativeKeywords: String, reviews: Array<String>): Array<Int> {
  return arrayOf()
}
