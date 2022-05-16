class RatingInfoVO{
    Integer totalScore
    Integer averageScore
    Integer totalVotes

    static RatingInfoVO mapper(RatingInfoCO ratingInfoCO)
    {
        RatingInfoVO ratingInfoVO = new RatingInfoVO()
        ratingInfoVO.setAverageScore(ratingInfoCO.averageVotes)
        ratingInfoVO.setTotalScore(ratingInfoCO.totalScore)
        ratingInfoVO.setTotalVotes(ratingInfoCO.totalVotes)
        ratingInfoVO
    }
}
