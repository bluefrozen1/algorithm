package wt;

public class TestMain2 {

    public static void main(String[] args) throws Exception {
//
//        다음과 같은 테이블이 있다.
//
//        컬럼 id | alphabet | number
//        1. id는 auto_increment 되는 키
//        2. alpabet는 A~Z까지 값이 들어감. 값은 unique 하지 않다.
//        3. number는 1~3까지 값이 들어감. 값은 unique 하지 않다.
//
//        해당 테이블에서 값을 가져와 id가 꼭 들어간 List<?>를  만드려고 한다.
//
//        리스트는 다음과 같이 만들어져야 된다.
//        1. 알파벳 순서대로
//        2. 알파벳이 같은 경우 number가 우선시 되야 된다. number가 같을시 하나만 포함된다.
//        3. 디비 전체 조회시 order는 성능상 한가지 조건으로만 가능하다.  조건절을 넣으면 성능에 문제가 없고 order에도 제약은 없다.
//
//
//        // 1안)
//        // 1. 알파벳을 asc ordering 하여 데이터 조회
//        // 2. 알파멧 내에서 number 중복제거 및 정렬
//        String sql = "SELECT ALPABET, NUMBER, ID FROM TABLE ORDER BY ALPABET ASC";
//        List<Domain> list = new ArrayList<>();
//        list.sort(new Comparator<Domain>() {
//            @Override
//            public int compare(Domain o1, Domain o2) {
//                if(o1.getAlpabet().compareTo(o2.getAlpabet())) {
//
//                }
//                return 0;
//            }
//        });
//
//        // 2안) 알파벳_넘버_id 를 조합한 A값을 만들고 쿼리
//        String sql = "SELECT distinct Concat(alpabet, number)
//        FROM table
//        Order By Concat(alpabet, number);
//
//
//    }
//
//    public static class Domain {
//        private String alpabet;
//        private Integer number;
//        private Long id;
//
//        public String getAlpabet() {
//            return alpabet;
//        }
//
//        public void setAlpabet(String alpabet) {
//            this.alpabet = alpabet;
//        }
//
//        public Integer getNumber() {
//            return number;
//        }
//
//        public void setNumber(Integer number) {
//            this.number = number;
//        }
//
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
    }
}
