import com.application.TourApplication

object Main extends App {

  while (!new TourApplication(3,3).findTour) {}

}
