package org.denigma.semantic.styles


import scalacss.Defaults._
import scalacss.LengthUnit.em

trait SelectionStyles extends Colors{
  self:StyleSheet.Standalone =>
  import dsl._


  val itemTextColor = c"rgba(179, 179, 179, 0.7)"
  val itemTextHoverColor = c"rgba(140, 140, 140, 0.7)"
  val selectionHoverBoxShadow = "0px 0px 2px 0px rgba(0, 0, 0, 0.05)"
  val selectionBoxShadow =  "0px 0px 4px 0px rgba(0, 0, 0, 0.08)"
  val optionsMenuBoxShadow = "0px 2px 6px 0px rgba(0, 0, 0, 0.1)"
  ".fluid" -(
    display.flex,
    flexWrap.wrap,
    alignContent.spaceBetween
    )

  ".flexible" - display.inlineFlex

  ".selection.box" -(
     boxShadow := "0px 0px 0px 1px rgba(34, 36, 38, 0.15) inset",
     display.flex,
     flexWrap.wrap,
     alignContent.spaceBetween,
     backgroundColor.white
    )

  ".selection.search"-(
    display.inlineFlex,
    //boxShadow := "0px 0px 0px 1px rgba(34, 36, 38, 0.15) inset",
    boxShadow := "",
    border.none,
    background := "none",
    width.auto,
    flexGrow(1)
    )

  ".selection.item"-(
    boxShadow := "0 0 0 1px rgba(34,36,38,.15) inset",
    fontSize(1 rem),
    padding(0.357 em, 0.714 em),
    margin(0.214 em, 0.285 em,0.21 em, 0 em),
    backgroundColor(tealBackground),
    cursor.pointer,
    color(itemTextColor),
    lineHeight(1.2 em),
    fontWeight.normal,
    &.hover(
      color(itemTextHoverColor)
      )
  )

  ".selection.options"-(
    display.flex,
    flexDirection.column,
    overflowY.scroll,
    overflowX.visible,
    maxHeight(200 px),
    backgroundColor.white
  )

  ".selection.option"-(
    display.inlineFlex,
    margin(0.214 em, 0.285 em,0.21 em, 0 em),
    cursor.pointer,
    &.hover(
      backgroundColor(itemTextHoverColor)
    )
    )

}


/**
/*******************************
            Dropdown
  *******************************/

/*-------------------
       Element
--------------------*/

@transition:
  border-radius 0.1s ease,
  width 0.2s ease
;
@borderRadius: @defaultBorderRadius;

/*-------------------
       Content
--------------------*/

/* Icon */
@dropdownIconMargin: 0em 0em 0em 1em;

/* Current Text */
@textTransition: color 0.2s @defaultEasing;

/* Menu */
@menuBackground: #FFFFFF;
@menuMargin: 0em;
@menuPadding: 0em 0em;
@menuTop: 100%;
@menuWrap: nowrap;
@menuTextAlign: left;
@menuTransition: none;

@menuBorderWidth: 1px;
@menuBorder: @menuBorderWidth solid @borderColor;
@menuBoxShadow: 0px 1px 4px 0px @borderColor;
@menuBorderRadius: 0em 0em @borderRadius @borderRadius;
@menuTransition: opacity 0.2s ease;
@menuMinWidth: ~"calc(100% + "(@menuBorderWidth * 2)~")";
@menuZIndex: 11;

/* Text */
@textLineHeight: 1em;
@textLineHeightOffset: (@textLineHeight - 1em);

/* Menu Item */
@itemFontSize: 1rem;
@itemBorder: none;
@itemHeight: auto;
@itemDivider: none;
@itemColor: @textColor;
@itemVerticalPadding: 0.65rem;
@itemHorizontalPadding: 1.25rem;
@itemFontWeight: normal;
@itemLineHeight: 1.2em;
@itemLineHeightOffset: (@itemLineHeight - 1em);
@itemTextTransform: none;
@itemBoxShadow: none;

/* Sub Menu */
@subMenuTop: 0%;
@subMenuLeft: 100%;
@subMenuRight: auto;
@subMenuDistanceAway: -0.5em;
@subMenuMargin: 0em 0em 0em @subMenuDistanceAway;
@subMenuBorderRadius: 0em @borderRadius @borderRadius 0em;
@subMenuZIndex: 21;

/* Menu Header */
@menuHeaderColor: @darkTextColor;
@menuHeaderFontSize: 0.8em;
@menuHeaderFontWeight: bold;
@menuHeaderTextTransform: uppercase;
@menuHeaderMargin: 1rem 0rem 0.75rem;
@menuHeaderPadding: 0em @itemHorizontalPadding;

/* Menu Divider */
@menuDividerMargin: 0.5em 0em;
@menuDividerColor: rgba(0, 0, 0, 0.05);
@menuDividerSize: 1px;
@menuDividerBorder: @menuDividerSize solid @menuDividerColor;

/* Menu Input */
@menuInputMargin: 0.75rem @itemHorizontalPadding;
@menuInputMinWidth: 200px;
@menuInputVerticalPadding: 0.5em;
@menuInputHorizontalPadding: 1em;
@menuInputPadding: @menuInputVerticalPadding @menuInputHorizontalPadding;

/* Menu Image */
@menuImageMaxHeight: 2.5em;

/* Item Sub-Element */
@itemElementDistance: 0.75em;

/* Sub-Menu Dropdown Icon */
@itemDropdownIconDistance: 1em;
@itemDropdownIconFloat: right;
@itemDropdownIconMargin: @itemLineHeightOffset 0em 0em @itemDropdownIconDistance;

/* Description */
@itemDescriptionMargin: 0em 0em 0em 1em;
@itemDescriptionColor: @lightTextColor;

/* Floated Content */
@floatedDistance: 1em;

/*-------------------
        Types
--------------------*/

/* Selection */
@selectionMinWidth: 180px;
@selectionBackground: @white;
@selectionDisplay: inline-block;
@selectionItemDivider: 1px solid rgba(0, 0, 0, 0.05);
@selectionVerticalPadding: 0.8em;
@selectionHorizontalPadding: 1.1em;
@selectionPadding: @selectionVerticalPadding @selectionHorizontalPadding;
@selectionZIndex: 10;

@selectionTextIconDistance: 2em;
@selectionTextColor: @textColor;

@selectionBoxShadow: none;
@selectionBorderColor: @borderColor;
@selectionBorder: 1px solid @selectionBorderColor;
@selectionBorderRadius: @borderRadius;
@selectionIconOpacity: 0.8;
@selectionIconTransition: opacity 0.2s ease;
@selectionMenuBoxShadow: 0px 2px 4px 0px rgba(0, 0, 0, 0.08);
@selectionMenuItemBoxShadow: none;

@selectionTransition:
  @transition,
  box-shadow 0.2s @defaultEasing,
  border 0.2s @defaultEasing
;
@selectionMenuTransition:
  box-shadow 0.2s @defaultEasing,
  border 0.2s @defaultEasing
;

/* Responsive */
@selectionMobileMaxItems: 3;
@selectionTabletMaxItems: 4;
@selectionComputerMaxItems: 6;
@selectionWidescreenMaxItems: 8;

/* Derived */
@selectedBorderEMWidth: 0.0714em;
@selectionItemActualHeight: (@itemVerticalPadding * 2) + @itemLineHeight + @selectedBorderEMWidth;
@selectionMobileMaxMenuHeight: (@selectionItemActualHeight * @selectionMobileMaxItems);
@selectionTabletMaxMenuHeight: (@selectionItemActualHeight * @selectionTabletMaxItems);
@selectionComputerMaxMenuHeight: (@selectionItemActualHeight * @selectionComputerMaxItems);
@selectionWidescreenMaxMenuHeight: (@selectionItemActualHeight * @selectionWidescreenMaxItems);

/* Hover */
@selectionHoverBorderColor: @selectedBorderColor;
@selectionHoverBoxShadow: 0px 0px 2px 0px rgba(0, 0, 0, 0.05);

/* Visible */
@selectionVisibleBorderColor: @borderColor;
@selectionVisibleBoxShadow: 0px 0px 4px 0px rgba(0, 0, 0, 0.08);
@selectionVisibleTextFontWeight: normal;
@selectionVisibleTextColor: @hoveredTextColor;

/* Visible Hover */
@selectionVisibleHoverBorderColor: @selectedBorderColor;
@selectionVisibleHoverBoxShadow: 0px 0px 4px 0px rgba(0, 0, 0, 0.08);
@selectionVisibleHoverMenuBorder: 1px solid @selectedBorderColor;
@selectionVisibleHoverMenuBoxShadow: 0px 2px 6px 0px rgba(0, 0, 0, 0.1);

@selectionVisibleConnectingBorder: 0em;
@selectionVisibleIconOpacity: 1;

/* Search */
@searchMinWidth: '';

/* Search Selection */
@searchSelectionLineHeight: 1.2142em; /* browser default for webkit <input> */
@searchSelectionLineHeightOffset: ((@searchSelectionLineHeight - 1em) / 2);
@searchSelectionInputPadding: (@selectionVerticalPadding - @searchSelectionLineHeightOffset) @selectionHorizontalPadding;

@searchMobileMaxMenuHeight: @selectionMobileMaxMenuHeight;
@searchTabletMaxMenuHeight: @selectionTabletMaxMenuHeight;
@searchComputerMaxMenuHeight: @selectionComputerMaxMenuHeight;
@searchWidescreenMaxMenuHeight: @selectionWidescreenMaxMenuHeight;

/* Inline */
@inlineIconMargin: 0em 0.5em 0em 0.25em;
@inlineTextColor: inherit;
@inlineTextFontWeight: bold;
@inlineMenuDistance: 0.25em;
@inlineMenuBorderRadius: @borderRadius;

/*-------------------
       States
--------------------*/

/* Hovered */
@hoveredItemBackground: @transparentBlack;
@hoveredItemColor: @selectedTextColor;

/* Default Text */
@defaultTextColor: rgba(179, 179, 179, 0.7);
@defaultTextHoverColor: rgba(140, 140, 140, 0.7);

/* Loading */
@loadingZIndex: -1;

/* Active Menu Item */
@activeItemBackground: transparent;
@activeItemZIndex: @menuZIndex + 1;
@activeItemBoxShadow: none;
@activeItemFontWeight: bold;
@activeItemColor: @selectedTextColor;

/* Selected */
@selectedBackground: @subtleTransparentBlack;
@selectedColor: @selectedTextColor;

/* Error */
@errorItemTextColor: #D95C5C;
@errorItemHoverBackground: #FFF2F2;
@errorItemActiveBackground: #FDCFCF;

/*-------------------
      Variations
--------------------*/

/* Upward */
@upwardMenuBoxShadow: 0px 0px 4px 0px @borderColor;
@upwardMenuBorderRadius: @borderRadius @borderRadius 0em 0em;
@upwardSelectionHoverBoxShadow: 0px 0px 2px 0px rgba(0, 0, 0, 0.05);
@upwardSelectionVisibleBoxShadow: 0px 0px 4px 0px rgba(0, 0, 0, 0.08);
@upwardSelectionVisibleHoverBoxShadow: 0px 0px 4px 0px rgba(0, 0, 0, 0.05);
@upwardSelectionVisibleHoverMenuBoxShadow: 0px 0px 4px 0px rgba(0, 0, 0, 0.08);
@upwardSelectionVisibleBorderRadius:  @selectionVisibleConnectingBorder @selectionVisibleConnectingBorder @borderRadius @borderRadius;

/* Flyout Direction */
@leftMenuDropdownIconFloat: left;
@leftMenuDropdownIconMargin: @itemLineHeightOffset @itemElementDistance 0em 0em;

/* Simple */
@simpleTransitionDuration: 0.2s;
@simpleTransition: opacity @simpleTransitionDuration @defaultEasing;

/* Floating */
@floatingMenuDistance: 0.5em;
@floatingMenuBoxShadow: 0px 2px 5px 0px rgba(0, 0, 0, 0.15);
@floatingMenuBorderRadius: @borderRadius;

/* Pointing */
@pointingArrowOffset: -0.25em;
@pointingArrowDistanceFromEdge: 1em;

@pointingArrowBackground: @white;
@pointingArrowZIndex: 2;
@pointingArrowBoxShadow: -1px -1px 0px 1px rgba(0, 0, 0, 0.1);
@pointingArrowSize: 0.5em;

@pointingMenuDistance: 0.75em;
@pointingMenuBorderRadius: @borderRadius;

  */