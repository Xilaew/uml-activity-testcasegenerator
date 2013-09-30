
TITLE=title
TMP=tmp
FILE=slides
SRC=src 

all: $(TITLE).pdf

$(TITLE).pdf: $(TMP)/$(FILE).pdf
	cp $(TMP)/$(FILE).pdf ./$(TITLE).pdf

.PRECIOUS:   $(TMP)/$(FILE).aux


$(TMP):
	mkdir tmp

#$(TMP)/%.aux: ./src/%.tex $(TMP) bib.bib 
#	pdflatex -output-directory=$(TMP) -shell-escape "\\input{$<}"
#	pdflatex -output-directory=$(TMP) -shell-escape "\\input{$<}"


#$(TMP)/%.bbl: $(TMP)/%.aux
#	bibtex $<

$(TMP)/%.pdf: $(FILE).tex $(TMP) 
	pdflatex -output-directory=$(TMP) -shell-escape "\\input{$<}"
	pdflatex -output-directory=$(TMP) -shell-escape "\\input{$<}"
	pdflatex -output-directory=$(TMP) -shell-escape "\\input{$<}"

