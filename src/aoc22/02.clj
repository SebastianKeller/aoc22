(ns aoc22.02)

(def results
  {[:rock :paper] :loose
   [:rock :rock] :draw
   [:rock :scissor] :win
   [:paper :scissor] :loose
   [:paper :paper] :draw
   [:paper :rock] :win
   [:scissor :rock] :loose
   [:scissor :scissor] :draw
   [:scissor :paper] :win})

(def needed-card
  {[:rock :win] :paper
   [:rock :draw] :rock
   [:rock :loose] :scissor
   [:paper :win] :scissor
   [:paper :draw] :paper
   [:paper :loose] :rock
   [:scissor :win] :rock
   [:scissor :draw] :scissor
   [:scissor :loose] :paper})

(def points {:rock 1
             :paper 2
             :scissor 3
             :loose 0
             :draw 3
             :win 6})

(defn parse-shape [input]
  (case input
    ("A" "X") :rock
    ("B" "Y") :paper
    ("C" "Z") :scissor))

(defn parse-desired-result [input]
  (case input
    "X" :loose
    "Y" :draw
    "Z" :win))

(defn parse-shapes [input]
  (let [shapes (clojure.string/split input #" ")]
    (map parse-shape shapes)))

(defn run-round [[opponent player]]
  (let [result (get results [player opponent])]
    (+ (get points player)
       (get points result))))

(defn solution-1 [input]
  (transduce (comp
              (map parse-shapes)
              (map run-round))
    +
    (clojure.string/split-lines input)))

(defn parse-part2 [input]
  (let [c (clojure.string/split input #" ")
        shape (parse-shape (first c))
        result (parse-desired-result (last c))]
    [shape result]))

(defn get-cards [[opponent desired-result]]
  [opponent (get needed-card [opponent desired-result])])

(defn solution-2 [input]
  (transduce (comp
              (map parse-part2)
              (map get-cards)
              (map run-round))
             +
             (clojure.string/split-lines input)))

(defn part-1 []
  (solution-1 (slurp "inputs/02.txt")))

(defn part-2 []
  (solution-2 (slurp "inputs/02.txt")))
